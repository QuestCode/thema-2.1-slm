package lt1;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {
	public static int ID = 0;
	private int id;

	private Socket socket;
	private Corrector corrector;

	private ExecutorService recordPool;

	public Worker( Socket socket, Database database ) {
		this.id         = ++Worker.ID;
		this.socket     = socket;
		this.corrector  = new Corrector( database );
		this.recordPool = Executors.newCachedThreadPool();
	}

	public void run() {
		System.out.println( "[Worker #" + this.id + "] Started." );

		try {
			// Prepare
			BufferedReader in = new BufferedReader( new InputStreamReader( this.socket.getInputStream() ) );
			Record record;

			while( ! Thread.currentThread().isInterrupted() )
			{
				// Skip preface
				try {
					while( ! in.readLine().equals( "<?xml version=\"1.0\"?>" ) ); // Reset and skip
				}
				catch( Exception e ) {
					System.out.println( "[Worker #" + this.id + "] Socket closed. Shutting down." );

					break;
				}

				in.readLine();		// <WEATHERDATA>
				in.readLine();		// <MEASUREMENT>

				// Create new Record
				record = new Record( this.corrector );

				// Parse and set data
				try {
					record.setSTN	( Integer.parseInt( this.strip( in.readLine() ) ) );
				}
				catch( NumberFormatException e ) { System.err.println( "[Worker #" + this.id + "] Invalid data for STN" ); }
				try {
					record.setDATE	( this.strip( in.readLine() ) );
				}
				catch( NumberFormatException e ) { System.err.println( "[Worker #" + this.id + "] Invalid data for DATE" ); }
				try {
					record.setTIME	( this.strip( in.readLine() ) );
				}
				catch( NumberFormatException e ) { System.err.println( "[Worker #" + this.id + "] Invalid data for TIME" ); }
				try {
					record.setTEMP	( Double.parseDouble( this.strip( in.readLine() ) ) );
				}
				catch( NumberFormatException e ) { System.err.println( "[Worker #" + this.id + "] Invalid data for TEMP" ); record.setMissing("TEMP"); }
				try {
					record.setDEWP	( Double.parseDouble( this.strip( in.readLine() ) ) );
				}
				catch( NumberFormatException e ) { System.err.println( "[Worker #" + this.id + "] Invalid data for DEWP" ); record.setMissing("DEWP"); }
				try {
					record.setSTP	( Double.parseDouble( this.strip( in.readLine() ) ) );
				}
				catch( NumberFormatException e ) { System.err.println( "[Worker #" + this.id + "] Invalid data for STP" ); record.setMissing("STP"); }
				try {
					record.setSLP	( Double.parseDouble( this.strip( in.readLine() ) ) );
				}
				catch( NumberFormatException e ) { System.err.println( "[Worker #" + this.id + "] Invalid data for SLP" ); record.setMissing("SLP"); }
				try {
					record.setVISIB( Double.parseDouble( this.strip( in.readLine() ) ) );
				}
				catch( NumberFormatException e ) { System.err.println( "[Worker #" + this.id + "] Invalid data for VISIB" ); record.setMissing("VISIB"); }
				try {
					record.setWDSP	( Double.parseDouble( this.strip( in.readLine() ) ) );
				}
				catch( NumberFormatException e ) { System.err.println( "[Worker #" + this.id + "] Invalid data for WDSP" ); record.setMissing("WDSP"); }
				try {
					record.setPRCP	( Double.parseDouble( this.strip( in.readLine() ) ) );
				}
				catch( NumberFormatException e ) { System.err.println( "[Worker #" + this.id + "] Invalid data for PRCP" ); record.setMissing("PRCP"); }
				try {
					record.setSNDP	( Double.parseDouble( this.strip( in.readLine() ) ) );
				}
				catch( NumberFormatException e ) { System.err.println( "[Worker #" + this.id + "] Invalid data for SNDP" ); record.setMissing("SNDP"); }
				try {
					record.setFRSHTT( Integer.parseInt( this.strip( in.readLine() ), 2 ) ); // Binary to integer
				}
				catch( NumberFormatException e ) { System.err.println( "[Worker #" + this.id + "] Invalid data for FRSHTT" ); record.setMissing("FRSHTT"); }
				try {
					record.setCLDC	( Double.parseDouble( this.strip( in.readLine() ) ) );
				}
				catch( NumberFormatException e ) { System.err.println( "[Worker #" + this.id + "] Invalid data for CLDC" ); record.setMissing("CLDC"); }
				try {
					record.setWNDDIR( Integer.parseInt( this.strip( in.readLine() ) ) );
				}
				catch( NumberFormatException e ) { System.err.println( "[Worker #" + this.id + "] Invalid data for WNDDIR" ); record.setMissing("WNDDIR"); }

				// Execute Record
				this.recordPool.execute( record );

				// Skip surface
				in.readLine(); // </MEASUREMENT>
				in.readLine(); // </WEATHERDATA>
			}

			// Shutdown record pool
			this.recordPool.shutdownNow();

			// Block until shut down
			try { this.recordPool.awaitTermination( 2000, TimeUnit.SECONDS ); }
			catch( InterruptedException e ) {} //e.printStackTrace(); }
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
