import java.net.*;
import java.io.*;

public class Server
{
	public static void main( String[] args ) {
		try {
			// Setup server socket
			int port = 6052;

			System.out.println( "Listening on port " + port + ".." );

			ServerSocket sock = new ServerSocket( port );

			// Accept socket connections
			while( true ) {
				Socket client = sock.accept();

				// Handle incoming connection in seperate thread
				Thread thread = new Thread( new Server.Handler( client ) );
				thread.start();
			}
		}
		catch( IOException ioe ) {
			System.err.println( ioe );
		}
	}

	public static class Handler implements Runnable {
		private Socket sock;

		public Handler( Socket sock ) {
			this.sock = sock;
		}

		public void run() {
			try {
				// Get input/output streams
				PrintWriter pout   = new PrintWriter( sock.getOutputStream(), true );
				InputStream in     = sock.getInputStream();
				BufferedReader bin = new BufferedReader( new InputStreamReader( in ) );

				// Read lines (data) from socket
				String line;

				while( ( line = bin.readLine() ) != null ) {
					try {
						// Lookup given address
						System.out.println( "-- Looking up " + line );

						InetAddress hostAddress = InetAddress.getByName( line );
						String address          = hostAddress.getHostAddress();

						// Output found IP address
						System.out.println( "Resolved " + line + " to " + address );
						pout.println( address );
					}
					catch( UnknownHostException uhe ) {
						// IP address not found
						System.err.println( "Error resolving host " + line );
						pout.println( "Unable to resolve host " + line );
					}
				}

				sock.close();
			}
			catch( IOException ioe ) {
				System.err.println( ioe );
			}
		}
	}
}