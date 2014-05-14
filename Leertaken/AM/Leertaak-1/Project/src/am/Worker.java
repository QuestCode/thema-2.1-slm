package am;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;

public class Worker implements Runnable {

	public static int ID = 0;

	private int id;

	private Socket socket;
	private Corrector corrector;

	public Worker( Socket socket, Database database ) {
		this.id         = ++Worker.ID;
		this.socket     = socket;
		this.corrector  = new Corrector( database );
	}

	public void run() {
		// System.out.println( "[Worker #" + this.id + "] Started." );

		try {
			// Prepare
			BufferedReader in = new BufferedReader( new InputStreamReader( this.socket.getInputStream() ) );
			Object[] record;

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
					record = new Object[14];

					// Parse and set data
					try {
						record[ Record.STN ] = Integer.parseInt( this.strip( in.readLine() ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for STN" );
					}

					try {
						record[ Record.DATE ] = this.strip( in.readLine() );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for DATE" );
					}

					try {
						record[ Record.TIME ] = this.strip( in.readLine() );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for TIME" );
					}

					try {
						record[ Record.TEMP ] = Double.parseDouble( this.strip( in.readLine() ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for TEMP" );
					}

					try {
						record[ Record.DEWP ] = Double.parseDouble( this.strip( in.readLine() ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for DEWP" );
					}

					try {
						record[ Record.STP ] = Double.parseDouble( this.strip( in.readLine() ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for STP" );
					}

					try {
						record[ Record.SLP ] = Double.parseDouble( this.strip( in.readLine() ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for SLP" );
					}

					try {
						record[ Record.VISIB ] = Double.parseDouble( this.strip( in.readLine() ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for VISIB" );
					}

					try {
						record[ Record.WDSP ] = Double.parseDouble( this.strip( in.readLine() ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for WDSP" );
					}

					try {
						record[ Record.PRCP ] = Double.parseDouble( this.strip( in.readLine() ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for PRCP" );
					}

					try {
						record[ Record.SNDP ] = Double.parseDouble( this.strip( in.readLine() ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for SNDP" );
					}

					try {
						record[ Record.FRSHTT ] = Integer.parseInt( this.strip( in.readLine() ), 2 ); // Binary to integer
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for FRSHTT" );
					}

					try {
						record[ Record.CLDC ] = Double.parseDouble( this.strip( in.readLine() ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for CLDC" );
					}

					try {
						record[ Record.WNDDIR ] = Integer.parseInt( this.strip( in.readLine() ) );
					}
					catch( NumberFormatException e ) {
						// System.err.println( "[Worker #" + this.id + "] Invalid data for WNDDIR" );
					}

					in.readLine(); // </MEASUREMENT>

					// Execute Record
					corrector.validateAndInsert( record );
				}
			}

			// System.out.println("[Worker] Shutting down worker #" + this.id + "..");
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
