package lt1;

import java.lang.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.PreparedStatement;

public class Database {
	/**
	 * Variables
	 *******************************************************/
	private Connection connection;

	private String query = "INSERT INTO `measurement` (`STN`,`DATE`,`TIME`,`TEMP`,"
		+ "`DEWP`,`STP`,`SLP`,`VISIB`,`WDSP`,`PRCP`,`SNDP`,`FRSHTT`,`CLDC`,`WNDDIR`)"
		+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private PreparedStatement statement;

	private int bufferSize    = 50;
	private int count         = 0;
	private int queryCount    = 0;
	private int insertedCount = 0;

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

			statement = this.connection.prepareStatement(query);

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

	public void insertRecord( Record record ) {
		// Increment counter
		++count;

		// Add to prepared statement
		// (`STN`,`DATE`,`TIME`,`TEMP`,`DEWP`,`STP`,`SLP`,`VISIB`,`WDSP`,`PRCP`,`SNDP`,`FRSHTT`,`CLDC`,`WNDDIR`)";
		try {
			statement.setInt(1, record.getSTN());
			statement.setString(2, record.getDATE());
			statement.setString(3, record.getTIME());
			statement.setDouble(4, record.getTEMP());
			statement.setDouble(5, record.getDEWP());
			statement.setDouble(6, record.getSTP());
			statement.setDouble(7, record.getSLP());
			statement.setDouble(8, record.getVISIB());
			statement.setDouble(9, record.getWDSP());
			statement.setDouble(10, record.getPRCP());
			statement.setDouble(11, record.getSNDP());
			statement.setInt(12, record.getFRSHTT());
			statement.setDouble(13, record.getCLDC());
			statement.setInt(14, record.getWNDDIR());
			statement.addBatch();
		}
		catch(SQLException e) {
			System.err.println("[Database/insert] " + e.getMessage());
		}

		// Commit
		if( count == bufferSize ) {
			this.insertedCount += bufferSize;

			this.commitRecords();

			// Reset
			count = 0;
		}
	}

	public synchronized boolean commitRecords() {
		try {
			if( this.connection.isClosed() ) {
				System.err.println( "[Database/commitRecords] Can't execute because database is closed." );

				return false;
			}

			// Increment counter
			++queryCount;

			statement.executeBatch();
			SQLWarning warning = statement.getWarnings();

			if(warning != null) {
				// Print warning(s)
				System.err.println(warning);
				warning.printStackTrace();
			}

			this.connection.commit();

			warning = this.connection.getWarnings();

			if(warning != null) {
				// Print warning(s)
				System.err.println(warning);
				warning.printStackTrace();

				return false;
			}

			return true;
		}
		catch( SQLException e ) {
			// Print error
			e.printStackTrace();

			// Failure
			return false;
		}
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
