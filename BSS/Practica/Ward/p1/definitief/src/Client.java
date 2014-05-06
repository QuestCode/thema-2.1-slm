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