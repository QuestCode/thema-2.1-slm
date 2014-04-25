import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

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
                PrintWriter os = new PrintWriter(clientSocket.getOutputStream(), true);
                InputStream is = clientSocket.getInputStream();
                BufferedReader bis = new BufferedReader(new InputStreamReader(is));

                numConnections ++;

                os.println("Welcome connectionNr: #" + numConnections);
                os.println("Please enter a hostname");

                while((line = bis.readLine()) != null) {

                    System.out.println("Getting input...");
                    System.out.println(line);
                    os.print("IP: ");
                    System.out.println("IP: ");

                    try {
                        InetAddress hostAddress = InetAddress.getByName(line);
                        line = hostAddress.getHostAddress();
                    } catch(UnknownHostException e) {
                        System.err.println(e);
                        os.println("Unknown Host");
                    }

                    os.print(line);
                    System.out.println(line);
                    os.println();
                }
            }
            catch (IOException e) {
                System.err.println(e);
            }
        }

    }
}