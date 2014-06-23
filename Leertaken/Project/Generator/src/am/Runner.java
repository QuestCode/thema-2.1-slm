package am;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import am.Database;
import am.Server;
import am.Worker;

public class Runner {
	/**
	 * Bootstrap
	 *
	 * @param args
	 */
	public static void main( String[] args ) {
		new Runner();
	}

	/**
	 * Constructor
	 *
	 * Sets up new Server Thread and starts it.
	 */

	public Runner() {

		// Set corrector cache size
		Corrector.CACHE_SIZE = 12;

		// Database configuration
		String host       = "localhost";
		Integer port      = 27017;
		String collection = "meteor";

		Database database       = new Database( host, port, collection );
		Server server           = new Server( database );
		Thread serverThread     = new Thread( server );
		ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

		serverThread.start();

		System.out.println(
				  "--- CONFIGURATION ---\n"
				+ "Cache size         : " + Corrector.CACHE_SIZE + "\n"
				+ "Date               : " + new SimpleDateFormat( "yyyy/MM/dd 'at' HH:mm:ss" ).format( new Date() ) + "\n"
				+ "---------------------"
		);

		// Wait until notified
		try {
			while( Worker.ID == 0 ) { Thread.sleep( 10 ); }

			// Benchmark
			long startTime = System.nanoTime();

			System.out.println( "[Runner] Running (press Enter to stop)..");

			// Run until interrupted
			BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
			br.readLine();

			// Gather process information
			long memory     = Runtime.getRuntime().totalMemory();
			int threadCount = threadBean.getThreadCount();

			// Stop
			server.interrupt();

			// Block until gracefully terminated
			while( threadBean.getThreadCount() > 7 ) {
				System.out.println( "[Runner] Thread count: " + threadBean.getThreadCount() );
				Thread.sleep( 100 );
			}

			long endTime = System.nanoTime();

			// Get total row count
			Database database2 = new Database( host, port, collection );
			long rowCount      = database2.getActualQueryCount();

			// Close database connection
			database2.close();

			// Output information
			float actualTime        = (float) ( endTime - startTime ) / 1000000000;
			long queryCount         = database.getQueryCount();
			int workerCount         = Worker.ID;
			int expectedRecordCount = Math.round( workerCount * 10 * actualTime );

			System.out.print(
				  "--- CONFIGURATION ---\n"
				+ "Runtime            : " + actualTime + " seconds\n"
				+ "Cache size         : " + Corrector.CACHE_SIZE + "\n"
				+ "------- USAGE -------\n"
				+ "Date               : " + new SimpleDateFormat( "yyyy/MM/dd 'at' HH:mm:ss" ).format( new Date() ) + "\n"
				+ "Actual time        : " + actualTime + " seconds\n"
				+ "Memory             : " + String.format( "%.2f", (float) memory / 1024 / 1024 ) + " MB\n"
				+ "Threads            : " + threadCount + "\n"
				+ "Workers            : " + workerCount + "\n"
				+ "Queries            : " + queryCount + "\n"
				+ "Records            : " + database.getInsertedCount() + "\n"
				+ "In database        : " + rowCount + "\n"
				+ "Expected           : " + expectedRecordCount + "\n"
				+ "Efficiency         : " + String.format( "%.2f", ( (float) rowCount / Math.round( workerCount * 10 * actualTime ) ) * 100 ) + " %\n"
				+ "---------------------"
			);

		}
		catch( Exception e ) {
			// Print error
			System.err.println( e );
			e.printStackTrace();
		}
		finally {
			System.exit( 0 );
		}
	}
}
