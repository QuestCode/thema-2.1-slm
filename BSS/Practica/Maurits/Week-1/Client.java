import java.net.*;
import java.io.*;

public class Client
{
	public static void main( String[] args ) {
		try {
			// Get input/output streams
			Socket sock        = new Socket( "127.0.0.1", 6052 );
			PrintWriter pout   = new PrintWriter( sock.getOutputStream(), true );
			InputStream in     = sock.getInputStream();
			BufferedReader bin = new BufferedReader( new InputStreamReader( in ) );

			// Use given addresses (or default if none given)
			String[] addresses = ( args.length > 0 ? args : new String[] { "google.nl" } );

			// Process addresses
			for( int i = 0; i < addresses.length; ++i ) {
				// Write to socket
				pout.println( addresses[i] );

				// Output result from server
				System.out.println( bin.readLine() );
			}

			sock.close();
		}
		catch( IOException ioe ) {
			System.err.println( ioe );
		}
	}
}