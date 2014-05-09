import java.net.*;
import java.io.*;
import java.util.concurrent.*;

class Worker implements Runnable
{
	private int sleepTime = 10;

	private Socket connection;

    private Semaphore semaphore;

	public Worker(Socket connection, Semaphore semaphore) {
		this.connection = connection;
        this.semaphore = semaphore;
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

			// now close the socket connection and release a semaphore permit
			connection.close();
            semaphore.release();

		}
		catch (InterruptedException ie) { }
		catch (IOException ioe) { }
	}
}


public class TimedServer
{
	public static final int PORT = 2500;

    private static Semaphore semaphore = new Semaphore(3, true);

	public static void main(String[] args) {
		Socket connection;
		
		try {
			ServerSocket server = new ServerSocket(PORT);

			while (true) {

                // Try to acquire a semaphore permit.
                try {
                    semaphore.acquire();
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }

				connection = server.accept();

				Thread worker = new Thread(new Worker(connection, semaphore));
				worker.start();
			}
		}
		catch (java.io.IOException ioe) { }
	}
}
