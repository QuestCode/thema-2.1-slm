package am;

import java.lang.*;
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

	private String query = "INSERT INTO `measurement` (`STN`,`DATE`,`TIME`,`TEMP`,"
		+ "`DEWP`,`STP`,`SLP`,`VISIB`,`WDSP`,`PRCP`,`SNDP`,`FRSHTT`,`CLDC`,`WNDDIR`)"
		+ " VALUES";

	private StringBuilder valueBuffer;

	private int bufferSize        = 10;
	private int count             = 0;
	private int queryCount        = 0;
	private Integer insertedCount = 0;

	/**
	 * Constructor(s)
	 *******************************************************/
	public Database( String host, int port, String name, String username, String password ) {
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

		this.valueBuffer = new StringBuilder();
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

	public void insertRecord( Object[] record ) {
		String valueString = null;
		int valueCount     = 0;

		synchronized( this.valueBuffer ) {
			// Increment counter
			++count;

			// System.err.println("[Database/insert] Adding record #" + count );

			Record.appendToStringBuilder( record, this.valueBuffer );

			// If buffer is full
			if( count >= bufferSize ) {
				valueString = valueBuffer.deleteCharAt( valueBuffer.length() - 1 ).toString();
				this.valueBuffer.setLength( 0 ); // Empty buffer

				valueCount = count;
				count      = 0;

			}
		}

		// Commit
		if( valueString != null ) {
			this.insertValues( valueString, valueCount );
		}

		// Clean up
		valueString = null;
	}

	public void commitRecords() {
		String valueString = null;
		int valueCount     = 0;

		synchronized( this.valueBuffer ) {
			valueString = valueBuffer.deleteCharAt( valueBuffer.length() - 1 ).toString();
			this.valueBuffer.setLength( 0 ); // Empty buffer

			valueCount = count;
			count      = 0;
		}

		// Commit
		this.insertValues( valueString, valueCount );

		// Clean up
		valueString = null;
	}

	private void insertValues( String values, int count ) {
		if( this.execute( this.query + values ) ) {
			synchronized( this.insertedCount ) {
				this.insertedCount += count;
			}
		}
		else {
			System.err.println( "[Database] Error inserting record batch." );
		}
	}

	public synchronized boolean execute( String query ) {
		CallableStatement statement;
		SQLWarning warning;

		try {
			// Closed already
			if( this.connection.isClosed() ) {
				System.err.println( "[Database] Can't execute because database is closed." );

				return false;
			}

			// Increment counter
			++this.queryCount;

			// Execute query
			statement = this.connection.prepareCall( query );

			if( ! statement.execute() ) {
				// Handle warnings
				warning = statement.getWarnings();

				if( warning != null ) {
					// Print warning(s)
					System.err.println( warning );
					warning.printStackTrace();
				}
			}

			this.connection.commit();

			// Handle warnings
			warning = this.connection.getWarnings();

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
		finally {
			// Clean up
			statement = null;
			warning   = null;
		}
	}

	public synchronized ResultSet query( String query ) {
		ResultSet resultSet;
		SQLWarning warning;

		try {
			// Closed already
			if( this.connection.isClosed() ) {
				System.err.println( "[Database] Can't query because database is closed." );

				return null;
			}

			// Increment counter
			++queryCount;

			// Execute query
			resultSet = this.connection.createStatement().executeQuery( query );

			// Handle warnings
			warning = this.connection.getWarnings();

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
		finally {
			// Clean up
			warning = null;
		}
	}
}
