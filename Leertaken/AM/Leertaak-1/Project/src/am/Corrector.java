package lt1;

import java.sql.SQLException;
import java.util.ArrayList;

public class Corrector {

	private final static int CACHE_SIZE = 30;

	private Database database;
	private ArrayList<Record> cache;

	public Corrector( Database database ) {
		this.database = database;
		this.cache    = new ArrayList<Record>();
	}

	/**
	 * Extrapolation of records
	 */
	public synchronized void validateAndInsert( Record record ) throws SQLException {
		checkCacheSize();
		correctTemperature( record );
		correctMissing( record );
		cache.add( record );
		database.insertRecord( record );
	}

	private void checkCacheSize() {
		if( cache.size() == CACHE_SIZE ) {
			cache.remove( 0 );
		}
	}

	private Object predictPropertyValue( Record record, String property ) {
		if( cache.size() < 2 ) {
			return 0.0;
		}

		Object value;
		Double lastValue = 0.0;
		Double prevValue = null;
		Double meanDiff  = 0.0;

		// Sum the differences
		for( Record lastRecord : cache ) {
			value     = lastRecord.getProperty( property );
			lastValue = ( value instanceof Integer
							? Double.parseDouble( ( (Integer) value ).toString() )
							: (Double) lastValue
						);

			if( prevValue == null ) {
				prevValue = lastValue;
				continue;
			}

			meanDiff += lastValue - prevValue;
			prevValue = lastValue;
		}

		// Divide by total, minus one because we skipped the first one
		meanDiff /= ( cache.size() - 1 );

		// Return predicted value
		return lastValue + meanDiff;
	}

	private void correctTemperature( Record record ) {
		// Check temperature for deviation
		if( cache.size() < 2 ) {
			return;
		}

		// Check if record temperature exceeds deviation percentage
		Double currentValue   = record.getTEMP();
		Double predictedValue = (Double) predictPropertyValue( record, "TEMP" );

		if( Math.abs( ( currentValue - predictedValue ) / currentValue ) > 0.2 ) { // 20%
			record.setTEMP( predictedValue );
		}
	}

	private void correctMissing( Record record ) {
		ArrayList<String> missing = record.getMissing();

		if( missing.size() == 0 ) {
			return;
		}

		for( String property : missing ) {
			if( property.equals( "FRSHTT" ) ) {
				// Use previous for binary flags (or 0 if cache is empty)
				record.setFRSHTT( cache.size() > 0 ? cache.get( cache.size() - 1 ).getFRSHTT() : 0 );
				continue;
			}

			record.setProperty( property, predictPropertyValue( record, property ) );
		}
	}
}
