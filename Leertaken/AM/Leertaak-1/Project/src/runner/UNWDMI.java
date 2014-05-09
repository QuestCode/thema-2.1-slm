package runner;

import java.lang.management.ManagementFactory;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import lt1.Database;
import lt1.Server;
import lt1.Worker;

public class UNWDMI {
	private int runtime = 30; // seconds

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
		Server server       = new Server();
		Thread serverThread = new Thread( server );

		serverThread.start();

		Database database = server.getDatabase();

		// Wait until notified
		try {
			while( Worker.ID == 0 ) { Thread.sleep( 10 ); }

			// Run for half a minute
			Thread.sleep( this.runtime * 1000 );

			// Gather process information
			long memory     = Runtime.getRuntime().totalMemory();
			int threadCount = ManagementFactory.getThreadMXBean().getThreadCount();

			// Stop
			server.interrupt();

			// Get total row count
			ResultSet result = database.query( "SELECT COUNT(*) as total FROM measurement LIMIT 1" );

			if( result != null )	result.next();

			int rowCount = ( result != null ? result.getInt( "total" ) : 0 );

			// Close database connection
			database.close();

			// Output information
			int queryCount = database.getQueryCount() - 2; // Ignore TRUNCATE and SELECT COUNT query

			System.out.print(
				  "------- USAGE -------\n"
				+ "Date        : " + new SimpleDateFormat( "yyyy/MM/dd 'at' HH:mm:ss" ).format( new Date() ) + "\n"
				+ "Runtime     : " + this.runtime + " seconds\n"
				+ "Memory      : " + String.format( "%.2f", (float) memory / 1024 / 1024 ) + " MB\n"
				+ "Threads     : " + threadCount + "\n"
				+ "Workers     : " + Worker.ID + "\n"
				+ "Queries     : " + queryCount + "\n"
				+ "Records     : " + database.getInsertedCount() + "\n"
				+ "In buffer   : " + database.getBufferCount() + "\n"
				+ "In database : " + rowCount + "\n"
				+ "Expected    : " + ( Worker.ID * this.runtime ) + "\n"
				+ "Efficiency  : " + String.format( "%.2f", ( (float) rowCount / Worker.ID / this.runtime ) * 100 ) + " %\n"
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
