import java.io.*;
import java.net.*;

/**
 * Created by Ward on 25-4-14.
 */

public class Client {

    private String hostname;
    private int port;
    private Socket socket;
    private String line;

    private String url = "www.westminstercollege.edu";

    public static void main(String args[]) {
        int port = 6052;
        String hostname = "localhost";

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

        try {
            PrintWriter os = new PrintWriter(socket.getOutputStream(), true);
            InputStream is = socket.getInputStream();
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));

            while((line = bis.readLine()) != null) {
                System.out.println(line);

                line = bis.readLine();
                System.out.println(line);

                // We have had the welcomes message
                // Now output our url
                System.out.println(url);
                os.println(url);

                // Write back our response
                line = bis.readLine();
                System.out.println(line);

                break;
            }
            socket.close();
            System.exit(0);
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
}