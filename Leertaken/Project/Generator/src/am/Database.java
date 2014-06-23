package am;

import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.mongodb.ParallelScanOptions;
import com.mongodb.MongoInterruptedException;

import java.util.List;
import java.util.Set;

public class Database {
	/**
	 * Variables
	 *******************************************************/
	private MongoClient mongoClient;
	private DB database;
	private DBCollection collection;

	private long queryCount    = 0;
	private Long insertedCount = 0L;

	/**
	 * Constructor(s)
	 *******************************************************/
	public Database( String host, int port, String name ) {
		try {
			this.mongoClient = new MongoClient( host, port );

			this.mongoClient.setWriteConcern( WriteConcern.UNACKNOWLEDGED );

			// Connect to database
			this.database = mongoClient.getDB( name );

			this.collection = this.database.getCollection( "measurements" );

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
	public DBCollection getCollection() {
		return this.collection;
	}

	public long getQueryCount() {
		return this.queryCount;
	}

	public long getActualQueryCount() {
		// Get actual measurement count
		return this.collection.count();
	}

	public long getInsertedCount() {
		return this.insertedCount;
	}

	/**
	 * Setters
	 *******************************************************/

	/**
	 * Connection methods
	 *******************************************************/
	public void clearMeasurements() {
		// Empty measurements document
		this.collection.remove( new BasicDBObject() );
	}

	public void close() {
		System.out.println( "[Database] Closing connection.." );

		// Close connection
		this.mongoClient.close();
	}

	/**
	 * Querying
	 *******************************************************/
	public synchronized void insertValue( BasicDBObject value ) {
		try {
			// Increment counter
			++this.queryCount;

			// Execute query
			this.collection.insert( value );

			// Increment counter
			++this.insertedCount;
		}
		catch( MongoInterruptedException ie ) {
			// On shutdown
		}
		catch( Exception e ) {
			System.err.println( "[Database] Error inserting record: " + e.getMessage() );
		}
	}
}
