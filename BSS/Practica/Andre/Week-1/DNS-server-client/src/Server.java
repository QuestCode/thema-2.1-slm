import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by Andre Nanninga on 25-4-14.
 */
public class Server {

    private int port = 6052;
    private ServerSocket socket;
    private ArrayList<Connection> connections;
    private Boolean isDebug = true;

    public Server() {
        connections = new ArrayList<Connection>();

        try {
            createServerSocket();
            listenToServerSocket();
        }
        catch (IOException e) {
            System.err.println("Critical error: " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Create a server socket
     *
     * @throws IOException
     */
    public void createServerSocket() throws IOException {
        debug("server/createServerSocket", "Creating serverSocket with port: " + port);
        socket = new ServerSocket(port);
    }

    /**
     * Set the server to listen to clients
     *
     * @throws IOException
     */
    public void listenToServerSocket() throws IOException {
        while(true) {
            Socket client = socket.accept();
            debug("server/listenToServerSocket", "accepting client: " + client.getInetAddress());

            createConnection(client);
        }
    }

    /**
     * create a new connection
     *
     * @param client The socket of the client of the connection
     * @throws IOException
     */
    private void createConnection(Socket client) throws IOException {
        Connection connection = new Connection(this, client);
        new Thread(connection).start();
        connections.add(connection);
    }

    /**
     * Close the connection and remove it from the connections pool
     *
     * @param connection The connection to close and remove
     * @throws IOException
     */
    private void closeConnection(Connection connection) throws IOException {
        connection.close();
        connections.remove(connection);
    }

    /**
     * Get the ip of a hostname
     *
     * @param hostname The hostname
     * @return The resolved ip of the hostname
     */
    public String getIpByHostname(String hostname) {
        try {
            InetAddress hostAddress = InetAddress.getByName(hostname);
            return hostAddress.getHostAddress();
        }
        catch (UnknownHostException e) {
            debug("Server/getIpByHostname", "could not resolve: " + hostname);
            return "Unable to resolve host " + hostname;
        }
    }

    /**
     * Print a message to the console when isDebug is set to true
     *
     * @param location Location of the code where the message was debugged
     * @param message Message of the debug
     */
    public void debug(String location, String message) {
        if(isDebug) {
            System.out.println("[" + location + "] - " + message);
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
