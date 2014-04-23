import java.net.*;
import java.io.*;
import java.util.concurrent.*;

class Worker implements Runnable
{
	private int sleepTime = DURATION;

	private Socket connection;

	public Worker(Socket connection) {
		this.connection = connection;
	}

	public void run() {
		try {
			PrintWriter pout = new PrintWriter(connection.getOutputStream(), true);

			while (sleepTime > 0) {	
				String s = (sleepTime == 1) ? " second." : " seconds.";
				pout.println("Sleeping " + sleepTime + " more " + s);
				Thread.sleep(1000);
				sleepTime -= 1;
			}

			// now close the socket connection
			connection.close();

		}
		catch (InterruptedException ie) { }
		catch (IOException ioe) { }
	}
}


public class TimedServer
{
	public static final int PORT = 2500;

	public static void main(String[] args) {
		Socket connection;
		
		try {
			ServerSocket server = new ServerSocket(PORT);

			while (true) {
				connection = server.accept();

				Thread worker = new Thread(new Worker(connection));
				worker.start();
			}
		}
		catch (InterruptedException ie) { }
		catch (java.io.IOException ioe) { }
	}
}
