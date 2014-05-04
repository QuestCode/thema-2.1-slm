import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by Ward on 25-4-14.
 */

public class Connection implements Runnable{

    private BufferedReader is;
    private PrintStream os;
    private Socket clientSocket;
    private int id;
    private Server server;
    private String line;

    public Connection(Socket clientSocket, int id, Server server) {

        this.clientSocket = clientSocket;
        this.id = id;
        this.server = server;

        try {
            PrintWriter os = new PrintWriter(clientSocket.getOutputStream(), true);
            InputStream is = clientSocket.getInputStream();
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));
        } catch (IOException line) {
            System.out.println(line);
            os.println(line);
        }
    }

    public void run() {

        try {
            // Geef een welkoms bericht
            os.println("Welcome connectionNr: #" + id);
            os.println("Please enter a hostname");

            // Zodra we input krijgen zet deze om naar output en geef deze terug
            while ((line = is.readLine()) != null) {

                System.out.println("Getting input...");
                System.out.println(line);
                os.print("IP: ");
                System.out.println("IP: ");

                try {
                    InetAddress hostAddress = InetAddress.getByName(line);
                    line = hostAddress.getHostAddress();
                } catch (UnknownHostException e) {
                    System.err.println(e);
                    os.println("Unknown Host");
                }

                os.print(line);
                System.out.println(line);
                os.println();

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}