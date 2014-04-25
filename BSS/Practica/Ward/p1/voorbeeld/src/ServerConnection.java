/**
 * Created by Ward on 24-4-14.
 */
import java.io.*;
import java.net.*;


class ServerConnection implements Runnable {
    BufferedReader is;
    PrintStream os;
    Socket clientSocket;
    int id;
    Server server;

    public ServerConnection(Socket clientSocket, int id, Server server) {
        this.clientSocket = clientSocket;
        this.id = id;
        this.server = server;
        System.out.println( "Connection " + id + " established with: " + clientSocket );
        try {
            is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            os = new PrintStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void run() {
        String line;
        try {
            boolean serverStop = false;

            while (true) {
                line = is.readLine();
                System.out.println( "Received " + line + " from Connection " + id + "." );
                int n = Integer.parseInt(line);
                if ( n == -1 ) {
                    serverStop = true;
                    break;
                }
                if ( n == 0 ) break;
                os.println("" + n*n );
            }

            System.out.println( "Connection " + id + " closed." );
            is.close();
            os.close();
            clientSocket.close();

            if ( serverStop ) server.stopServer();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}