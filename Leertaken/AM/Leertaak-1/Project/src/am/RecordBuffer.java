package am;

import java.lang.StringBuilder;

public class RecordBuffer {

	public static int MIN_BUFFER_SIZE = 100;
	public static int MAX_BUFFER_SIZE = 200;

	private Database database;
	private StringBuilder buffer;
	private int count;

	public RecordBuffer( Database database ) {
		this.database = database;
		this.buffer   = new StringBuilder();
		this.count    = 0;
	}

	public void add( Object[] record ) {
		Record.appendToStringBuilder( record, this.buffer );

		this.count += 1;

		// System.out.println( "[RecordBuffer] adding record: " + this.count );

		// Apply a 0.1% chance to write when the min buffer size is exceeded
		if( (this.count >= RecordBuffer.MIN_BUFFER_SIZE && Math.random() < 0.001) || (this.count >= RecordBuffer.MAX_BUFFER_SIZE) ) {
			this.write();
		}
	}

	public void write() {
		if( this.count == 0 ) {
			return;
		}

		// System.out.println( "[RecordBuffer] writing " + this.count + " records to database" );

		// Write buffer
		this.database.insertValues( this.buffer.deleteCharAt( buffer.length() - 1 ).toString(), this.count );

		// Empty buffer
		this.buffer.delete(0, this.buffer.length());
		this.count = 0;
		System.gc();
	}
}