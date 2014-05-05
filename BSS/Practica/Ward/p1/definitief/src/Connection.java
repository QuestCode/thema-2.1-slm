import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by Ward on 25-4-14.
 */

public class Connection implements Runnable {

    private BufferedReader is;
    private PrintStream os;
    private Socket clientSocket;
    private int id;
    private Server server;
    private String line;
    private String address;

    public Connection(Socket clientSocket, int id, Server server) {

        this.clientSocket = clientSocket;
        this.id = id;
        this.server = server;
    }

    public void run() {

        // Zet de input/output streams
        try {
            PrintWriter os = new PrintWriter(clientSocket.getOutputStream(), true);
            InputStream is = clientSocket.getInputStream();
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));


            // Zodra we input krijgen zet deze om naar output en geef deze terug
            while ((line = bis.readLine()) != null) {

                try {
                    InetAddress hostAddress = InetAddress.getByName(line);
                    address = hostAddress.getHostAddress();
                } catch (UnknownHostException e) {
                    System.err.println(e);
                    os.println("Unknown Host");
                }

                System.out.println( "Resolved " + line + " to " + address );

                // Geef het ip terug
                os.print(address);

            }
            clientSocket.close();

        } catch (IOException line) {
            System.out.println(line);
            os.println(line);
        }
    }
}