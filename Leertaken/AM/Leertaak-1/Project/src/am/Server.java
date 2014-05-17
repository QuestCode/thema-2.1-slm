package am;

import java.net.ServerSocket;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Server implements Runnable
{
	ServerSocket socket;
	private ExecutorService workerPool;
	private Database database;

	public Server() {
		// Create worker pool
		this.workerPool = Executors.newFixedThreadPool( 850 );

		// Connect to database
		this.database = new Database( "localhost", 3306, "unwdmi", "root", "banaan" );

		// Clear measurements table
		if( this.database.execute( "TRUNCATE TABLE `measurement`" ) ) {
			System.out.println( "[Server] Measurements cleared." );
		}
		else {
			throw new RuntimeException( "[Server] Error clearing measurements!" );
		}
	}

	public Database getDatabase() {
		return this.database;
	}

	public void interrupt() throws IOException {
		System.out.println( "[Server] Shutting down.." );

		// Close socket
		this.socket.close();

		// Shutdown workers
		this.workerPool.shutdownNow();

		// Block until shut down
		try {
			this.workerPool.awaitTermination( 120, TimeUnit.SECONDS );
		}
		catch( InterruptedException e ) {
			e.printStackTrace();
		}

		// Shutdown executors and release locks
		try {
			this.database.shutdownExecutors();
			this.database.commit();
		}
		catch( SQLException e ) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			// Start server socket
			this.socket = new ServerSocket( 7789 );
			Thread t;

			System.out.println( "[Server] Accepting.." );

			// Accept incoming sockets
			while( ! Thread.currentThread().isInterrupted() ) {
				try {
					// Create new Worker Thread
					t = new Thread( new Worker( this.socket.accept(), this.database ) );

					// t.setPriority( Thread.MAX_PRIORITY );

					// Add to pool and execute
					this.workerPool.execute( t );
				}
				catch( IOException e ) {
					// Check if socket not closed
					if( this.socket.isClosed() )
						break;

					// Print error
					System.err.println( e );
					e.printStackTrace();
				}
			}
		}
		catch( Exception e ) {
			// Print error
			System.err.println( e );
			e.printStackTrace();
		}

		System.out.println( "[Server] Shutdown." );
	}
}
