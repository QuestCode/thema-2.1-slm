import java.io.*;
import java.net.*;

/**
 * Created by Yuri on 25/4/2014.
 */
public class TelnetListener {
    /**
     * Constructor
     * @param port port number to listen to
     */
    public TelnetListener(int port) {

        // local variables
        ServerSocket socket = null;
        Socket client = null;
        PrintWriter printWriter = null;

        try {
            // Start listening to socket on port (port was given from main)
            socket = new ServerSocket(port);

            while (true) {
                /// Accept telnet connection
                client = socket.accept();

                // Get print writer (to write output back to client)
                printWriter = new PrintWriter(client.getOutputStream(), true);

                // Get input stream (to receive input from client)
                InputStream inputStream = client.getInputStream();

                // Start new ConnectionListener thread with input and output streams and the connection (to be able to close it)
                new Thread(new ConnectionListener(inputStream, printWriter, client)).start();
            }
        }
        catch(Exception ex){

        }
    }
}
