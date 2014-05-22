package am;

import com.mongodb.BasicDBObject;

public class RecordBuffer {

	public static int BUFFER_SIZE = 100;

	private Database database;
	private BasicDBObject buffer[];
	private int count;

	public RecordBuffer( Database database ) {
		this.database = database;
		this.buffer   = new BasicDBObject[ BUFFER_SIZE ];
		this.count    = 0;
	}

	public void add( Object[] record ) {
		this.buffer[ this.count ] = Record.toDBObject( record );

		this.count += 1;

		// System.out.println( "[RecordBuffer] adding record: " + this.count );

		if( this.count >= RecordBuffer.BUFFER_SIZE ) {
			this.write();
		}
	}

	public void write() {
		if( this.count == 0 ) {
			return;
		}

		// System.out.println( "[RecordBuffer] writing " + this.count + " records to database" );

		// Write buffer
		BasicDBObject tempBuffer[]   = new BasicDBObject[ BUFFER_SIZE ];
		int i;

		for( i = 0; i < BUFFER_SIZE; ++i ) {
			tempBuffer[i]  = this.buffer[i];
			this.buffer[i] = null;
		}

		this.database.insertValues( tempBuffer );

		// Empty buffer
		this.count  = 0;

		System.gc();
	}
}