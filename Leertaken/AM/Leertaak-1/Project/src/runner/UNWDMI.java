package runner;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import lt1.Database;
import lt1.Server;
import lt1.Worker;

public class UNWDMI {
	private int runtime = 10; // seconds

	/**
	 * Bootstrap
	 *
	 * @param args
	 */
	public static void main( String[] args ) {
		new UNWDMI();
	}

	/**
	 * Constructor
	 *
	 * Sets up new Server Thread and starts it.
	 */

	public UNWDMI() {
		Server server           = new Server();
		Thread serverThread     = new Thread( server );
		ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

		serverThread.start();

		Database database = server.getDatabase();

		// Wait until notified
		try {
			while( Worker.ID == 0 ) { Thread.sleep( 10 ); }

			System.out.println( "[UNWDMI] Running..");

			// Run for given period of time
			Thread.sleep( this.runtime * 1000 );

			// Gather process information
			long memory     = Runtime.getRuntime().totalMemory();
			int threadCount = threadBean.getThreadCount();

			// Stop
			server.interrupt();

			// System.out.println( "[UNWDMI] Thread count: " + threadBean.getThreadCount() );
			while( threadBean.getThreadCount() > 100 ) { Thread.sleep( 10 ); }

			// Get total row count
			ResultSet result = database.query( "SELECT COUNT(*) as total FROM measurement LIMIT 1" );
			int rowCount     = -1;

			if( result != null ) {
				result.next();
				rowCount = result.getInt( "total" );
			}

			// Output information
			int queryCount          = database.getQueryCount();
			int workerCount         = Worker.ID;
			int expectedRecordCount = ( workerCount * 10 * this.runtime );

			// Close database connection
			System.out.println( "[UNWDMI] Closing database connection.." );

			database.close();

			System.out.print(
				  "------- USAGE -------\n"
				+ "Date        : " + new SimpleDateFormat( "yyyy/MM/dd 'at' HH:mm:ss" ).format( new Date() ) + "\n"
				+ "Runtime     : " + this.runtime + " seconds\n"
				+ "Memory      : " + String.format( "%.2f", (float) memory / 1024 / 1024 ) + " MB\n"
				+ "Threads     : " + threadCount + "\n"
				+ "Workers     : " + workerCount + "\n"
				+ "Queries     : " + queryCount + "\n"
				+ "Records     : " + database.getInsertedCount() + "\n"
				+ "In buffer   : " + database.getBufferCount() + "\n"
				+ "In database : " + rowCount + "\n"
				+ "Expected    : " + expectedRecordCount + "\n"
				+ "Efficiency  : " + String.format( "%.2f", ( (float) rowCount / expectedRecordCount ) * 100 ) + " %\n"
				+ "---------------------\n"
			);
		}
		catch( Exception e ) {
			// Print error
			System.err.println( e );
			e.printStackTrace();
		}
	}
}
