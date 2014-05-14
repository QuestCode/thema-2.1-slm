package am;

import java.lang.StringBuilder;
import java.util.ArrayList;

public class Record {

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

	public static ArrayList<Integer> determineMissing( Object[] record ) {
		ArrayList<Integer> missing = new ArrayList<Integer>();

		if( record[ Record.TEMP   ] == null ) { missing.add( Record.TEMP   ); }
		if( record[ Record.DEWP   ] == null ) { missing.add( Record.DEWP   ); }
		if( record[ Record.STP    ] == null ) { missing.add( Record.STP    ); }
		if( record[ Record.SLP    ] == null ) { missing.add( Record.SLP    ); }
		if( record[ Record.VISIB  ] == null ) { missing.add( Record.VISIB  ); }
		if( record[ Record.WDSP   ] == null ) { missing.add( Record.WDSP   ); }
		if( record[ Record.PRCP   ] == null ) { missing.add( Record.PRCP   ); }
		if( record[ Record.SNDP   ] == null ) { missing.add( Record.SNDP   ); }
		if( record[ Record.FRSHTT ] == null ) { missing.add( Record.FRSHTT ); }
		if( record[ Record.CLDC   ] == null ) { missing.add( Record.CLDC   ); }
		if( record[ Record.WNDDIR ] == null ) { missing.add( Record.WNDDIR ); }

		return missing;
	}

	public static void appendToStringBuilder( Object[] record, StringBuilder builder ) {
		builder
			.append( "(" + record[ Record.STN ]   +  "," )
			.append( "'" + record[ Record.DATE ]  + "'," )
			.append( "'" + record[ Record.TIME ]  + "'," )
			.append( "'" + record[ Record.TEMP ]  + "'," )
			.append( "'" + record[ Record.DEWP ]  + "'," )
			.append( "'" + record[ Record.STP ]   + "'," )
			.append( "'" + record[ Record.SLP ]   + "'," )
			.append( "'" + record[ Record.VISIB ] + "'," )
			.append( "'" + record[ Record.WDSP ]  + "'," )
			.append( "'" + record[ Record.PRCP ]  + "'," )
			.append( "'" + record[ Record.SNDP ]  + "'," )
			.append( record[ Record.FRSHTT ] + "," )
			.append( "'" + record[ Record.CLDC ]  + "'," )
			.append( record[ Record.WNDDIR ] + ")," )
			;
	}
}