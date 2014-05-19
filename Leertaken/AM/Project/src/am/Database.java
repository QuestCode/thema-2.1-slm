package am;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Database {
	/**
	 * Variables
	 *******************************************************/
	private Connection connection;
	private ExecutorService executorPool;
	private int queriesPerCommit = 15;

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

			// Create cached thread pool
			this.executorPool = Executors.newCachedThreadPool();
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

	public synchronized boolean execute( String query ) {
		try {
			// Closed already
			if( this.connection.isClosed() ) {
				System.err.println( "[Database] Can't execute because database is closed." );

				return false;
			}

			// Increment counter
			++this.queryCount;

			// Execute query
			this.executorPool.submit( new Executor( this.connection, query ) );

			// Commit every X queries
			if( this.queryCount % this.queriesPerCommit == 0 ) {
				this.commit();
			}

			return true;
		}
		catch( SQLException e ) {
			e.printStackTrace();

			return false;
		}
	}

	public void commit() throws SQLException {
		this.connection.commit();
	}

	public void shutdownExecutors() {
		this.executorPool.shutdownNow();
	}

	protected class Executor implements Runnable {

		private Connection connection;
		public String query;

		public Executor( Connection connection, String query ) {
			this.connection = connection;
			this.query      = query;
		}

		public void run() {
			try {
				this.connection.createStatement().executeUpdate( this.query );
			}
			catch( SQLException e ) {
				e.printStackTrace();
			}
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
			++this.queryCount;

			// Execute query
			return this.connection.createStatement().executeQuery( query );
		}
		catch( SQLException e ) {
			// Print error
			e.printStackTrace();

			// Failure
			return null;
		}
	}
}
