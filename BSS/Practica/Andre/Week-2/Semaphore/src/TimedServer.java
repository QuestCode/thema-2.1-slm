import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class TimedServer {

  public static final int PORT = 2500;
  public static final int LIMIT = 2;

  public static void main(String[] args){
    try {
      ServerSocket server = new ServerSocket(PORT);
      Semaphore semaphore = new Semaphore(LIMIT);

      while(true) {
        semaphore.acquire();

        Socket socket = server.accept();

        Thread worker = new Thread(new Worker(socket, semaphore));
        worker.start();
      }
    }
    catch(Exception e) {
      System.err.println(e.getMessage());
      System.exit(0);
    }
  }
}