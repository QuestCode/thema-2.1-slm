package am;

// http://api.mongodb.org/java/current/index.html
import java.net.ServerSocket;
import java.io.IOException;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.List;

public class Server implements Runnable
{
	ServerSocket socket;
	private ExecutorService workerPool;
	private Database database;
	public static Boolean isOpen;

	public Server( Database database ) {
		this.database = database;

		// Create worker pool
		this.workerPool = Executors.newFixedThreadPool( 850 );

		// Clear measurements table
		this.database.clearMeasurements();

		System.out.println( "[Server] Measurements cleared." );
	}

	public void interrupt() throws IOException {
		System.out.println( "[Server] Shutting down.." );

		// Close socket
		this.socket.close();

		// Flag workers that the server is no longer open
		Server.isOpen = false;

		// Shutdown workers
		this.workerPool.shutdownNow();

		try {
			if (!this.workerPool.awaitTermination(10, SECONDS)) {
				this.workerPool.shutdownNow();
			}
		}
		catch( Exception e ) {
			this.workerPool.shutdownNow();
		}

		// Close database connection
		this.database.close();
	}

	public void run() {
		try {
			// Start server socket
			this.socket = new ServerSocket( 7789 );
			Thread t;

			// Flag workers that the server is now open
			Server.isOpen = true;
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
