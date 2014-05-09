import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class Worker implements Runnable {
  private int timer = 10;

  private Socket socket;
  private Semaphore semaphore;

  public Worker(Socket socket, Semaphore semaphore) {
    this.socket = socket;
    this.semaphore = semaphore;
  }

  public void run() {
    try {
      PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

      while(timer > 0) {
        writer.println("Sleeping for " + timer + " more second(s).");

        Thread.sleep(1000);

        timer--;
      }
    }
    catch(Exception e) {
      System.err.println(e.getMessage());
    }
    finally {
      semaphore.release();

      try {
        socket.close();
      }
      catch(Exception e) {
        System.err.println(e.getMessage());
      }
    }
  }
}