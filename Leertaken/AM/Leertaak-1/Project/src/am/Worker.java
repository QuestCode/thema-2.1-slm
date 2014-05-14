package lt1;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;
// import java.util.concurrent.TimeUnit;

import java.util.ArrayList;

public class Worker implements Runnable {
	public static int ID = 0;
	private int id;

	private Socket socket;
	private Corrector corrector;

	// private ExecutorService recordPool;

	public Worker( Socket socket, Database database ) {
		this.id         = ++Worker.ID;
		this.socket     = socket;
		this.corrector  = new Corrector( database );
		// this.recordPool = Executors.newCachedThreadPool();
	}

	public void run() {
		// System.out.println( "[Worker #" + this.id + "] Started." );

		try {
			// Prepare
			BufferedReader in = new BufferedReader( new InputStreamReader( this.socket.getInputStream() ) );
			Record record;

			while( ! Thread.currentThread().isInterrupted() ) {
				// Skip preface
				try {
					while( ! in.readLine().equals( "<?xml version=\"1.0\"?>" ) ); // Reset and skip
				}
				catch( Exception e ) {
					// System.out.println( "[Worker #" + this.id + "] Socket closed. Shutting down." );

					break;
				}

				in.readLine(); // <WEATHERDATA>

				// Read <MEASUREMENT> until </WEATHERDATA> is found
				while( in.readLine().equals( "\t<MEASUREMENT>" ) ) {
					// Prepare
					record = new Record( this.corrector );

					// Parse and set data
					try {
						record.setSTN( Integer.parseInt( this.strip( in.readLine() ) ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for STN" );
					}

					try {
						record.setDATE( this.strip( in.readLine() ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for DATE" );
					}

					try {
						record.setTIME( this.strip( in.readLine() ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for TIME" );
					}

					try {
						record.setTEMP( Double.parseDouble( this.strip( in.readLine() ) ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for TEMP" );
					}

					try {
						record.setDEWP( Double.parseDouble( this.strip( in.readLine() ) ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for DEWP" );
					}

					try {
						record.setSTP( Double.parseDouble( this.strip( in.readLine() ) ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for STP" );
					}

					try {
						record.setSLP( Double.parseDouble( this.strip( in.readLine() ) ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for SLP" );
					}

					try {
						record.setVISIB( Double.parseDouble( this.strip( in.readLine() ) ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for VISIB" );
					}

					try {
						record.setWDSP( Double.parseDouble( this.strip( in.readLine() ) ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for WDSP" );
					}

					try {
						record.setPRCP( Double.parseDouble( this.strip( in.readLine() ) ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for PRCP" );
					}

					try {
						record.setSNDP( Double.parseDouble( this.strip( in.readLine() ) ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for SNDP" );
					}

					try {
						record.setFRSHTT( Integer.parseInt( this.strip( in.readLine() ), 2 ) ); // Binary to integer
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for FRSHTT" );
					}

					try {
						record.setCLDC( Double.parseDouble( this.strip( in.readLine() ) ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for CLDC" );
					}

					try {
						record.setWNDDIR( Integer.parseInt( this.strip( in.readLine() ) ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for WNDDIR" );
					}

					in.readLine(); // </MEASUREMENT>

					// Execute Record
					record.run();
					// this.recordPool.execute( record );
				}
			}

			// System.out.println("[Worker] shutting down..");
			// recordPool.shutdownNow();
			socket.close();
		}
		catch( Exception e ) {
			// Print error
			System.err.println( e );
			e.printStackTrace();
		}
	}

	protected String strip( String value )
	{
		return value.substring( value.indexOf( '>' ) + 1, value.lastIndexOf( '<' ) );
	}
}
