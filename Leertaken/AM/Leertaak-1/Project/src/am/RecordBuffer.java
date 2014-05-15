package am;

import java.lang.StringBuilder;

public class RecordBuffer {

	public static int BUFFER_SIZE = 100;

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

		if( this.count >= RecordBuffer.BUFFER_SIZE ) {
			this.write();
		}
	}

	public void write() {
		if( this.count == 0 ) {
			return;
		}

		// Write buffer
		this.database.insertValues( this.buffer.deleteCharAt( buffer.length() - 1 ).toString(), this.count );

		// Empty buffer
		this.buffer.setLength( 0 );
		this.count = 0;
	}
}