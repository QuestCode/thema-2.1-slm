package am;

import java.util.ArrayList;

public class Corrector {

	public static int CACHE_SIZE = 30;

	private Object[][] cache;
	private int cachePointer;

	public Corrector() {
		this.cache        = new Object[ CACHE_SIZE ][ Record.SIZE ];
		this.cachePointer = 0;
	}

	/**
	 * Extrapolation of records
	 */
	public void validate( Object[] record ) {
		checkCacheSize();
		// correctTemperature( record );
		correctMissing( record );

		cache[ cachePointer ] = record;
		cachePointer++;
	}

	private void checkCacheSize() {
		if( cachePointer == CACHE_SIZE ) {
			cachePointer = 0;
		}
	}

	private Object predictPropertyValue( Object[] record, int property ) {
		if( cache[1][ Record.STN ] == null ) { // Cache size < 2
			return null;
		}

		int i, size = 0;
		Object value;
		Double lastValue = 0.0;
		Double prevValue = null;
		Double meanDiff  = 0.0;

		// Sum the differences
		for( i = 0; i < CACHE_SIZE; ++i ) {
			if( cache[i][ Record.STN ] == null ) {
				break;
			}

			size     += 1;
			value     = cache[ i ][ property ];
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

		// Divide by total, minus one (because n objects have n - 1 differences)
		meanDiff  /= ( size - 1 ); // index = size
		lastValue += meanDiff;

		// Clean up
		prevValue = null;
		meanDiff  = null;

		// Return predicted value
		return lastValue;
	}

	private void correctTemperature( Object[] record ) {
		// Check temperature for deviation
		if( cache[1][ Record.STN ] == null ) { // Cache size < 2
			return;
		}

		// Check if record temperature exceeds deviation percentage
		Double currentValue   = (Double) record[ Record.TEMP ];
		Double predictedValue = (Double) predictPropertyValue( record, Record.TEMP );

		if(  predictedValue != null && Math.abs( ( currentValue - predictedValue ) / currentValue ) > 0.2 ) { // 20%
			record[ Record.TEMP ] = predictedValue;
		}

		// Clean up
		currentValue   = null;
		predictedValue = null;
	}

	private void correctMissing( Object[] record ) {
		int i;
		Integer[] missing = Record.determineMissing( record );

		if( missing[0] == null ) {
			return;
		}

		for( i = 0; i < missing.length; ++i ) {
			if( missing[i] == null ) {
				break;
			}
			if( missing[i] == Record.FRSHTT ) {
				// Use previous for binary flags (or 0 if cache is empty)
				record[ Record.FRSHTT ] = 0;

				if( cache[ cachePointer ] != null ) {
					record[ Record.FRSHTT ] = cache[ cachePointer ][ Record.FRSHTT ];
				}

				continue;
			}

			record[ missing[i] ] = predictPropertyValue( record, missing[i] );
		}

		// Clean up
		missing = null;
	}
}
