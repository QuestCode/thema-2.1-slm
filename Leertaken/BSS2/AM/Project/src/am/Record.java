package am;

import com.mongodb.BasicDBObject;

public class Record {

	/**
	 * Record properties (read by Worker)
	 */
	public final static int STN    = 0;
	public final static int DATE   = 1;
	public final static int TIME   = 2;
	public final static int TEMP   = 3;
	public final static int DEWP   = 4;
	public final static int STP    = 5;
	public final static int SLP    = 6;
	public final static int VISIB  = 7;
	public final static int WDSP   = 8;
	public final static int PRCP   = 9;
	public final static int SNDP   = 10;
	public final static int FRSHTT = 11;
	public final static int CLDC   = 12;
	public final static int WNDDIR = 13;

	public final static int SIZE         = 14;
	public final static int MISSING_SIZE = 4;

	/**
	 * Make int array with keys of missing values
	 *
	 * @param Object[] record
	 * @return Integer[] missing
	 */
	public static Integer[] determineMissing( Object[] record ) {
		Integer[] missing  = new Integer[ MISSING_SIZE ];
		int i, missingPointer = 0;

		// From TEMP - WNDDIR
		for( i = TEMP; i < SIZE; ++i ) {
			if( record[i] == null ) {
				missing[ missingPointer++ ] = i;

				// Maximum missing is reached
				if( missingPointer == MISSING_SIZE ) {
					System.err.println( "Maximum missing reached for record: " + record );
					break;
				}
			}
		}

		return missing;
	}

	/**
	 * Append insert query "(stn, date, ..)" to StringBuilder
	 *
	 * @param Object[] record
	 * @param StringBuilder builder
	 */
	public static BasicDBObject toDBObject( Object[] record ) {
		return new BasicDBObject( "stn", record[ Record.STN ] )
			.append( "date"  , record[ Record.DATE   ] )
			.append( "time"  , record[ Record.TIME   ] )
			.append( "temp"  , record[ Record.TEMP   ] )
			.append( "dewp"  , record[ Record.DEWP   ] )
			.append( "stp"   , record[ Record.STP    ] )
			.append( "slp"   , record[ Record.SLP    ] )
			.append( "visib" , record[ Record.VISIB  ] )
			.append( "wdsp"  , record[ Record.WDSP   ] )
			.append( "prcp"  , record[ Record.PRCP   ] )
			.append( "sndp"  , record[ Record.SNDP   ] )
			.append( "frshtt", record[ Record.FRSHTT ] )
			.append( "cldc"  , record[ Record.CLDC   ] )
			.append( "wnddir", record[ Record.WNDDIR ] )
			;
	}
}