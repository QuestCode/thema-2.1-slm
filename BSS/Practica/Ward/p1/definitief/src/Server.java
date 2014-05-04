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