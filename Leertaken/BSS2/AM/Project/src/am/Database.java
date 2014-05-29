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

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Database {
	/**
	 * Variables
	 *******************************************************/
	private MongoClient mongoClient;
	private DB database;
	private DBCollection collection;
	private ExecutorService executorPool;

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
	public void increaseInsertedCount( long count ) {
		synchronized( this.insertedCount ) {
			this.insertedCount += count;
		}
	}

	/**
	 * Connection methods
	 *******************************************************/
	public void clearMeasurements() {
		// Empty measurements document
		this.collection.remove( new BasicDBObject() );
	}

	public void close() {
		// Close connection
		this.mongoClient.close();
	}

	/**
	 * Querying
	 *******************************************************/
	public void insertValues( BasicDBObject[] values ) {
		try {
			// Increment counter
			++this.queryCount;

			// Execute query
			this.executorPool.submit( new Executor( this, values ) );
		}
		catch( Exception e ) {
			System.err.println( "[Database] Error inserting record batch." );

			e.printStackTrace();
		}
	}

	public void shutdownExecutors() {
		this.executorPool.shutdownNow();
	}

	protected class Executor implements Runnable {

		private Database database;
		public BasicDBObject values[];

		public Executor( Database database, BasicDBObject[] values ) {
			this.database = database;
			this.values   = values;
		}

		public void run() {
			int i = 0;
			DBCollection collection = database.getCollection();

			try {

				for( ; i < values.length; ++i ) {
					if( values[i] == null ) {
						break; // Buffer commited early
					}
					collection.insert( values[i] );
				}

				++i;
			}
			catch( MongoInterruptedException e ) {
				// On Shutdown
			}
			catch( Exception e ) {
				e.printStackTrace();
			}
			finally {
				this.database.increaseInsertedCount( Long.valueOf( i ) );

				// Clean up
				collection = null;
			}
		}
	}
}
