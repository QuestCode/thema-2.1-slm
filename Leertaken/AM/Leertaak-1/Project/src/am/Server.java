package am;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server implements Runnable
{
	ServerSocket socket;
	private ExecutorService workerPool;
	private Database database;

	public Server() {
		// Create worker pool
		workerPool = Executors.newFixedThreadPool( 850 );

		// Connect to database
		this.database = new Database( "localhost", 3306, "unwdmi", "root", "banaan" );

		// Clear measurements table
		if( this.database.clearMeasurements() ) {
			System.out.println( "[Server] Measurements cleared." );
		}
		else {
			throw new RuntimeException( "[Server] Error clearing measurements!" );
		}

		// Set buffer size
		this.database.setBufferSize( 200 );
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
			this.workerPool.awaitTermination( 10, TimeUnit.SECONDS );
		}
		catch( InterruptedException e ) {
			e.printStackTrace();
		}
		finally {
			// Save database buffer
			System.out.println("[Server] Saving database buffer..");
			this.database.commitRecords();
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

					t.setPriority( Thread.MAX_PRIORITY );

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
