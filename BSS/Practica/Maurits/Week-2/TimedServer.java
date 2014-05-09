import java.net.*;
import java.io.*;
import java.util.concurrent.*;

class Worker implements Runnable {

	private int sleepTime = 10;

	private Socket sock;
	private Semaphore sem;

	public Worker( Socket sock, Semaphore sem ) {
		this.sock = sock;
		this.sem  = sem;
	}

	public void run() {
		try {
			PrintWriter pout = new PrintWriter( sock.getOutputStream(), true );

			while( sleepTime > 0 ) {
				String s = ( sleepTime == 1 ? " second." : " seconds." );

				pout.println( "Sleeping " + sleepTime + " more " + s );

				Thread.sleep( 1000 );

				sleepTime -= 1;
			}
		}
		catch( InterruptedException ie ) {}
		catch( IOException ioe ) { }
		finally {
			try {
				sock.close();
			}
			catch( IOException e ) {}

			// Allow other worker instances by releasing own lock
			sem.release();
		}
	}
}


public class TimedServer {

	public static final int PORT  = 2500;
	public static final int LIMIT = 2;

	public static void main( String[] args ) {
		Socket sock;

		try {
			ServerSocket server = new ServerSocket( PORT );

			// Create semaphore with worker limit
			Semaphore sem = new Semaphore( LIMIT );

			while( true ) {
				// Reserve worker instance by acquiring a single lock
				sem.acquire();

				sock = server.accept();

				Thread worker = new Thread( new Worker( sock, sem ) );
				worker.start();
			}
		}
		catch( InterruptedException ie ) {}
		catch( java.io.IOException ioe ) {}
	}
}
