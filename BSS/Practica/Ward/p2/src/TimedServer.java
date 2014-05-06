import java.net.*;
import java.io.*;
import java.util.concurrent.*;

class Worker implements Runnable
{
    private int sleepTime = 10;

    private Socket connection;
    private Semaphore sem;

    public Worker(Socket connection, Semaphore sem) {
        this.connection = connection;
        this.sem = sem;
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

        finally {
            sem.release();
        }
    }
}


public class TimedServer
{
    public static final int PORT = 2500;

    public static void main(String[] args) {

        Socket connection;
        Semaphore sem = new Semaphore(2);

        try {
            ServerSocket server = new ServerSocket(PORT);

            while (true) {

                sem.acquire();
                connection = server.accept();

                Thread worker = new Thread(new Worker(connection, sem));
                worker.start();
            }
        }
        catch (java.io.IOException ioe) { }
        catch (InterruptedException e) { }
    }
}
