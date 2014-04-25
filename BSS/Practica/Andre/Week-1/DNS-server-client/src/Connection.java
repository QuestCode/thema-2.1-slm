import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Andre Nanninga on 25-4-14.
 */
public class Connection implements Runnable {

    private Socket socket;
    private Server server;

    private BufferedReader reader;
    private PrintWriter writer;

    private Boolean isRunning = true;

    /**
     * A connection of a client
     *
     * @param server The server parent
     * @param socket The socket of the client
     * @throws IOException
     */
    public Connection(Server server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;

        writer = new PrintWriter(socket.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /**
     * Close the connection
     *
     * @throws IOException
     */
    public void close() throws IOException {
        isRunning = false;
        socket.close();
    }

    @Override
    /**
     * Reads and writes messages from the client
     */
    public void run() {
        String line = "";
        while(isRunning) {

            try {
                line = reader.readLine();
            }
            catch (IOException e) {
                server.debug("Connection/Run", "Error while reading line: " + e.getMessage());
                try {
                    close();
                }
                catch (IOException e1) { }
            }

            if(line != null) {
                server.debug("Connection/Run", "Received: " + line);

                String ip = server.getIpByHostname(line);

                writer.println(ip);
            }
        }
    }
}
