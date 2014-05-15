package am;

import java.sql.SQLException;
import java.util.ArrayList;

public class Corrector {

	private final static int CACHE_SIZE = 8;

	private Database database;
	private ArrayList<Object[]> cache;

	public Corrector( Database database ) {
		this.database = database;
		this.cache    = new ArrayList<Object[]>();
	}

	/**
	 * Extrapolation of records
	 */
	public void validateAndInsert( Object[] record ) {
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

	private Object predictPropertyValue( Object[] record, int property ) {
		if( cache.size() < 2 ) {
			return 0.0;
		}

		Object value;
		Double lastValue = 0.0;
		Double prevValue = null;
		Double meanDiff  = 0.0;

		// Sum the differences
		for( Object[] lastRecord : cache ) {
			value     = lastRecord[ property ];
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
		meanDiff  /= ( cache.size() - 1 );
		lastValue += meanDiff;

		// Clean up
		prevValue = null;
		meanDiff  = null;

		// Return predicted value
		return lastValue;
	}

	private void correctTemperature( Object[] record ) {
		// Check temperature for deviation
		if( cache.size() < 2 ) {
			return;
		}

		// Check if record temperature exceeds deviation percentage
		Double currentValue   = (Double) record[ Record.TEMP ];
		Double predictedValue = (Double) predictPropertyValue( record, Record.TEMP );

		if( Math.abs( ( currentValue - predictedValue ) / currentValue ) > 0.2 ) { // 20%
			record[ Record.TEMP ] = predictedValue;
		}

		// Clean up
		currentValue   = null;
		predictedValue = null;
	}

	private void correctMissing( Object[] record ) {
		ArrayList<Integer> missing = Record.determineMissing( record );

		if( missing.size() == 0 ) {
			return;
		}

		for( Integer property : missing ) {
			if( property == Record.FRSHTT ) {
				// Use previous for binary flags (or 0 if cache is empty)
				if( cache.size() > 0 ) {
					record[ Record.FRSHTT ] = cache.get( cache.size() - 1 )[ Record.FRSHTT ];
				}
				else {
					record[ Record.FRSHTT ] = 0;
				}

				continue;
			}

			record[ property ] = predictPropertyValue( record, property );
		}

		// Clean up
		missing  = null;
		property = null;
	}
}
