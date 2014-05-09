import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Yuri on 25/4/2014.
 */
public class ConnectionListener implements Runnable {
    InputStream inputStream;
    PrintWriter printWriter;
    Socket connection;

    /**
     * Constructor
     * @param inputStream InputStream to receive client data from
     * @param printWriter printWriter to write output to client
     * @param connection Connection to client (to close after output)
     */
    public ConnectionListener(InputStream inputStream, PrintWriter printWriter, Socket connection){
        this.inputStream = inputStream;
        this.printWriter = printWriter;
        this.connection = connection;
    }

    /**
     * Run method (from Runnable)
     */
    @Override
    public void run(){
        String hostname = "";

        // Get data from client and output the IP (or output an error)
        while ((hostname = getString(inputStream)) != "") {
            try {
                InetAddress address = InetAddress.getByName(hostname);
                printWriter.println("IP address at: '" + hostname + "' is: " + address.getHostAddress().toString());
                connection.close();
            } catch (Exception ex) {
                printWriter.println("Could not parse address");
            }
        }
    }

    /**
     * Get string from inputstream
     * @param inputStream inputStream
     * @return a string of the line read from inputStream
     */
    private String getString(InputStream inputStream){
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();

        String line;

        try{
            // Create a bufferedreader to be able to read the inputstream line by line
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // Get a line from bufferedReader, if it's not empty, return the line.
            while((line = bufferedReader.readLine()) != null){
                System.out.println("Read: " + line);
                return line;
            }
        } catch (Exception ex){

        }
        return "";
    }
}
