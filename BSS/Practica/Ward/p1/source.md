#Client

```java
import java.io.*;
import java.net.*;

/**
 * Created by Ward on 25-4-14.
 */

public class Client {

    private String hostname;
    private int port;
    private Socket socket;

    // De url waarvan we het IP willen hebben
    private String url = "www.westminstercollege.edu";

    public static void main(String args[]) {
        int port = 6052;
        String hostname = "localhost";

        // Maak verbinding met de server
        Client client = new Client( port, hostname );

        client.startClient();
    }
    public Client(int port, String hostname) {
        this.port = port;
        this.hostname = hostname;
    }


    public void startClient() {
        try {
            socket = new Socket( hostname, port);
        }
        catch (IOException e) {
            System.err.println(e);
        }

        // Zet de input/output streams
        try {
            PrintWriter os = new PrintWriter(socket.getOutputStream(), true);
            InputStream is = socket.getInputStream();
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));

            String line;

            // Stuur de aanvraag en haal het antwoord op
            while(true) {

                // De url waarvan we het ip willen
                os.println(url);

                // Geef het antwoord
                line = bis.readLine();
                System.out.println(line);

                break;
            }
            // Verbreek de verbinding
            socket.close();
            System.exit(0);
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
}
```

#Server

```java
import java.io.*;
import java.net.*;

/**
 * Created by Ward on 25-4-14.
 */

public class Server {

    private ServerSocket socket = null;
    private Socket clientSocket = null;
    private int numConnections = 0;
    private int port;
    private String line;


    public static void main(String args[]) {
        int port = 6052;
        Server server = new Server( port );

        // Start de server
        server.startServer();
    }
    public Server(int port) {
        this.port = port;
    }


    public void startServer() {
        try {
            socket = new ServerSocket( port );
        }
        catch (IOException e) {
            System.err.println(e);
        }

        while(true) {
            try {
                clientSocket = socket.accept();

                // Hou bij hoeveel clients we gehad hebben
                numConnections++;

                Connection connection = new Connection(clientSocket, numConnections, this);
                new Thread(connection).start();
            }
            catch (IOException e) {
                System.err.println(e);
            }
        }

    }
}
```


#Connection

```java
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
                os.println(address);

            }
            clientSocket.close();

        } catch (IOException line) {
            System.out.println(line);
            os.println(line);
        }
    }
}
```