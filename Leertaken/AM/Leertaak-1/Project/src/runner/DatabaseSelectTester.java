package runner;

import java.sql.*;
import lt1.Database;

public class DatabaseSelectTester {

	public static void main( String[] args ) throws SQLException {
		Database database = new Database( "127.0.0.1", 3306, "unwdmi", "root", "banaan" );
		ResultSet result  = database.query( "SELECT * FROM measurement" );

		System.out.println( "Results:" );

		while( result.next() ) {
			// Process results one row at a time
			System.out.println(
				" stn = " + result.getInt( 1 ) +
				" date = " + result.getString( 2 ) +
				" time = " + result.getString( 3 ) +
				" temp = " + result.getDouble( 4 ) +
				" dewp = " + result.getDouble( 5 ) +
				" stp = " + result.getDouble( 6 ) +
				" slp = " + result.getDouble( 7 ) +
				" visib = " + result.getDouble( 8 ) +
				" wdsp = " + result.getDouble( 9 ) +
				" prcp = " + result.getDouble( 10 ) +
				" sndp = " + result.getDouble( 11 ) +
				" frshtt = " + result.getInt( 12 ) +
				" cldc = " + result.getDouble( 13 ) +
				" wnddir = " + result.getInt( 14 )
			);
		}
	}
}
