package am;

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

	/**
	 * Setters
	 *******************************************************/

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

	public void insertValues( String values, int count ) {
		if( this.execute( this.query + values ) ) {
			synchronized( this.insertedCount ) {
				this.insertedCount += count;
			}
		}
		else {
			System.err.println( "[Database] Error inserting record batch." );
		}
	}

	private synchronized boolean execute( String query ) {
		try {
			// Closed already
			if( this.connection.isClosed() ) {
				System.err.println( "[Database] Can't execute because database is closed." );

				return false;
			}

			// Increment counter
			++this.queryCount;

			// Execute query
			Thread t = new Thread( new Database.Executor( this.connection, query ) );
			t.start();

			return true;
		}
		catch( Exception e ) {
			e.printStackTrace();

			return false;
		}
	}

	private class Executor implements Runnable {

		private Connection connection;
		private String query;

		public Executor( Connection connection, String query ) {
			this.connection = connection;
			this.query      = query;
		}

		public void run() {
			CallableStatement statement;
			SQLWarning warning;

			try {
				// Execute query
				statement = this.connection.prepareCall( this.query );

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
				}
			}
			catch( SQLException e ) {
				// Print error
				e.printStackTrace();
			}
			finally {
				// Clean up
				statement = null;
				warning   = null;
			}
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
			++this.queryCount;

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
