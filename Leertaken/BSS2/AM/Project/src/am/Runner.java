package am;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;

import am.Database;
import am.Server;
import am.Worker;

public class Runner {
	private int runtime = 10; // seconds

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

		// Set query buffer size
		RecordBuffer.BUFFER_SIZE = 50;

		// Set corrector cache size
		Corrector.CACHE_SIZE = 12;

		Server server           = new Server();
		Thread serverThread     = new Thread( server );
		ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
		Database database       = server.getDatabase();

		serverThread.start();

		System.out.println(
				  "--- CONFIGURATION ---\n"
				+ "Runtime            : " + this.runtime + " seconds\n"
				+ "Record buffer size : " + RecordBuffer.BUFFER_SIZE + "\n"
				+ "Cache size         : " + Corrector.CACHE_SIZE + "\n"
				+ "Date               : " + new SimpleDateFormat( "yyyy/MM/dd 'at' HH:mm:ss" ).format( new Date() ) + "\n"
				+ "---------------------"
		);

		// Wait until notified
		try {
			while( Worker.ID == 0 ) { Thread.sleep( 10 ); }

			// Benchmark
			long startTime = System.nanoTime();

			System.out.println( "[Runner] Running..");

			// Run for given period of time
			Thread.sleep( this.runtime * 1000 );

			// Gather process information
			long memory     = Runtime.getRuntime().totalMemory();
			int threadCount = threadBean.getThreadCount();

			// Stop
			server.interrupt();

			// Block until gracefully terminated
			while( threadBean.getThreadCount() > 6 ) {
				// System.out.println( "[Runner] Thread count: " + threadBean.getThreadCount() );
				Thread.sleep( 100 );
			}

			long endTime = System.nanoTime();

			// Get total row count
			long rowCount = database.getActualQueryCount();

			// Close database connection
			System.out.println( "[Runner] Closing database connection.." );

			database.close();

			// Output information
			float actualTime        = (float) ( endTime - startTime ) / 1000000000;
			long queryCount         = database.getQueryCount();
			int workerCount         = Worker.ID;
			int expectedRecordCount = Math.round( workerCount * 10 * actualTime );

			System.out.print(
				  "--- CONFIGURATION ---\n"
				+ "Runtime            : " + this.runtime + " seconds\n"
				+ "Record buffer size : " + RecordBuffer.BUFFER_SIZE + "\n"
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
				+ "Expected (1)       : " + Math.round( workerCount * 10 * this.runtime ) + "\n"
				+ "Expected (2)       : " + expectedRecordCount + "\n"
				+ "Efficiency         : " + String.format( "%.2f", ( (float) rowCount / Math.round( workerCount * 10 * this.runtime ) ) * 100 ) + " %\n"
				+ "---------------------"
			);

		}
		catch( Exception e ) {
			// Print error
			System.err.println( e );
			e.printStackTrace();
		}
		finally {
			System.exit(0);
		}
	}
}
