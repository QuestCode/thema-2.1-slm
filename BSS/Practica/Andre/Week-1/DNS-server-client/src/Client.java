import java.io.*;
import java.net.Socket;

/**
 * Created by Andre Nanninga on 25-4-14.
 */
public class Client {

    private String serverHost = "localhost";
    private int serverPort = 6052;

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    private Boolean isDebug = true;

    /**
     * The host to resolve the ip of
     *
     * @param host
     */
    public Client(String host) {
        String message = host;
        Boolean listening = true;

        try {
            socket = new Socket(serverHost, serverPort);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            writer.println(message);

            String line;
            while(listening) {
                if((line = reader.readLine()) != null) {
                    listening = false;
                }
            }
            socket.close();
        }
        catch (IOException e) {
            System.exit(0);
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
        if(args.length == 1) {
            new Client(args[0]);
        }
        else {
            System.err.println("Expected host as first argument");
            System.exit(0);
        }
    }
}
