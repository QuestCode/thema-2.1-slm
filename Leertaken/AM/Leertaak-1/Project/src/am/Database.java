package lt1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;

public class Database {
	/**
	 * Variables
	 *******************************************************/
	private Connection connection;

	private final String query = "INSERT INTO `measurement` (`STN`,`DATE`,`TIME`,`TEMP`,`DEWP`,`STP`,`SLP`,`VISIB`,`WDSP`,`PRCP`,`SNDP`,`FRSHTT`,`CLDC`,`WNDDIR`)VALUES";
	private String[] buffer;

	private int bufferSize    = 50;
	private int count         = 0;
	private int queryCount    = 0;
	private int insertedCount = 0;

	/**
	 * Constructor(s)
	 *******************************************************/
	public Database( String host, int port, String name, String username, String password ) {
		// Set up buffer
		this.buffer = new String[bufferSize];

		try {
			// Register driver
			DriverManager.registerDriver( new com.mysql.jdbc.Driver() );

			// Connect to database
			this.connection = DriverManager.getConnection( "jdbc:mysql://" + host + ":" + port + "/" + name, username, password );
			this.connection.setAutoCommit( false );

			System.out.println( "[Database] Connected to " + host + ":" + port );
		}
		catch( Exception e ) {
			// Print error
			e.printStackTrace();
		}
	}

	/**
	 * Getters
	 *******************************************************/
	public int getQueryCount() {
		return this.queryCount;
	}

	public int getInsertedCount() {
		return this.insertedCount;
	}

	public int getBufferCount() {
		return this.count;
	}

	public int getBufferSize() {
		return this.bufferSize;
	}

	/**
	 * Setters
	 *******************************************************/
	public void setBufferSize( int size ) {
		this.bufferSize = size;
		this.buffer     = new String[this.bufferSize];
	}

	/**
	 * Connection methods
	 *******************************************************/
	public synchronized boolean close() {
		try {
			// Closed already
			if( this.connection.isClosed() )
				return true;

			// Close connection
			this.connection.close();

			// Success
			return true;
		}
		catch( SQLException e ) {
			// Failure
			return false;
		}
	}

	/**
	 * Querying
	 *******************************************************/
	public boolean clearMeasurements() {
		return this.execute( "TRUNCATE TABLE `measurement`" );
	}

	public synchronized void insert( Record record ) {
		// Add to buffer
		this.buffer[count] = record.getQuery();

		// Increment counter
		++count;

		// Commit
		if( count == bufferSize ) {
			this.insertedCount += bufferSize;

			this.commit();

			// Reset
			count = 0;
		}
	}

	public void commit() {
		// Build query
		String values       = "";
		boolean appendComma = false;

		for( String q : this.buffer ) {
			values     += ( appendComma ? "," : "" ) + q;
			appendComma = true;
		}

		// Execute query
		this.execute( this.query + values );
	}

	public synchronized boolean execute( String query ) {
		try {
			// Closed already
			if( this.connection.isClosed() ) {
				System.err.println( "[Database] Can't execute because database is closed." );

				return false;
			}

			// Increment counter
			++queryCount;

			// Execute query
			CallableStatement statement = this.connection.prepareCall( query );

			if( ! statement.execute() ) {
				// Handle warnings
				SQLWarning warning = statement.getWarnings();

				if( warning != null ) {
					// Print warning(s)
					System.err.println( warning );
					warning.printStackTrace();
				}
			}

			this.connection.commit();

			// Handle warnings
			SQLWarning warning = this.connection.getWarnings();

			if( warning != null ) {
				// Print warning(s)
				System.err.println( warning );
				warning.printStackTrace();

				return false;
			}

			// Success
			return true;
		}
		catch( SQLException e ) {
			// Print error
			e.printStackTrace();

			// Failure
			return false;
		}
	}

	public synchronized ResultSet query( String query ) {
		try {
			// Closed already
			if( this.connection.isClosed() ) {
				System.err.println( "[Database] Can't query because database is closed." );

				return null;
			}

			// Increment counter
			++queryCount;

			// Execute query
			ResultSet resultSet = this.connection.createStatement().executeQuery( query );

			// Handle warnings
			SQLWarning warning = this.connection.getWarnings();

			if( warning != null ) {
				// Print warning(s)
				System.err.println( warning );
				warning.printStackTrace();

				return null;
			}

			// Success
			return resultSet;
		}
		catch( SQLException e ) {
			// Print error
			e.printStackTrace();

			// Failure
			return null;
		}
	}
}
