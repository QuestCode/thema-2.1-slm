package lt1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Corrector {
	private Database database;
	private List<Record> cache;

	public Corrector( Database database ) {
		this.database = database;
		cache         = new ArrayList<Record>();
	}

	public void validateAndInsert( Record record ) throws SQLException {
		// Extrapolation of records
		if( cache.size() == 30 ) {
			cache.remove( 0 );
		}

		if( cache.size() > 0 ) {
			// Check temperature for wrong values.
			Iterator<Record> it = cache.listIterator();
			int count           = 1;
			Double counter      = 0.0;
			Double prevTemp     = null;
			Double lastTemp     = null;

			while( it.hasNext() ) {
				lastTemp = it.next().getTEMP();

				if( count == 1 ) {
					prevTemp = lastTemp;

				}
				else {
					double diff = lastTemp - prevTemp;
					counter     = counter + diff;
					prevTemp    = lastTemp;
				}

				count++;
			}

			if( counter != null ) {
				double diff;
				double newTemp;

				diff    = counter / cache.size();
				newTemp = lastTemp + diff;

				// 20% difference check
				double tempDiff = ( record.getTEMP() - newTemp ) / record.getTEMP();

				if( tempDiff > 0.20 || tempDiff < -0.20 ) {
					record.setTEMP( newTemp );
				}

				//System.out.println(record.getSTN() + "/" + record.getTIME() + "/" + tempDiff + "/" + newTemp + "/-/" + lastTemp + "/-/" + counter);
			}

			// Check for missing value and change it
			// System.out.println(record.getMissing());
			if( record.getMissing() != null ) {
				Iterator<Record> itAll = cache.listIterator();
				int countAll           = 1;
				Double counterAll      = 0.0;
				Double prevAll         = null;
				Double lastAll         = null;

				while( itAll.hasNext() ) {
					Record missing = itAll.next();

					if     ( record.getMissing().equals( "TEMP" ) )   { lastAll = missing.getTEMP(); }
					else if( record.getMissing().equals( "DEWP" ) )   { lastAll = missing.getDEWP(); }
					else if( record.getMissing().equals( "STP" ) )    { lastAll = missing.getSTP(); }
					else if( record.getMissing().equals( "SLP" ) )    { lastAll = missing.getSLP(); }
					else if( record.getMissing().equals( "VISIB" ) )  { lastAll = missing.getVISIB(); }
					else if( record.getMissing().equals( "WDSP" ) )   { lastAll = missing.getWDSP(); }
					else if( record.getMissing().equals( "PRCP" ) )   { lastAll = missing.getPRCP(); }
					else if( record.getMissing().equals( "SNDP" ) )   { lastAll = missing.getSNDP(); }
					else if( record.getMissing().equals( "FRSHTT" ) ) { lastAll = (double) missing.getFRSHTT(); }
					else if( record.getMissing().equals( "CLDC" ) )   { lastAll = missing.getCLDC(); }
					else if( record.getMissing().equals( "WNDDIR" ) ) { lastAll = (double) missing.getWNDDIR(); }

					if( countAll == 1 ) {
						prevAll = lastAll;
					}
					else {
						double diff = lastAll - prevAll;
						counterAll  = counterAll + diff;
						prevTemp    = lastTemp;
					}

					countAll++;
				}

				if( counterAll != null ) {
					double diff;
					double newAll;

					diff   = counterAll / cache.size();
					newAll = lastAll + diff;

					if     ( record.getMissing().equals( "TEMP" ) )   { record.setTEMP( newAll ); }
					else if( record.getMissing().equals( "DEWP" ) )   { record.setDEWP( newAll ); }
					else if( record.getMissing().equals( "STP" ) )    { record.setSTP( newAll ); }
					else if( record.getMissing().equals( "SLP" ) )    { record.setSLP( newAll ); }
					else if( record.getMissing().equals( "VISIB" ) )  { record.setVISIB( newAll ); }
					else if( record.getMissing().equals( "WDSP" ) )   { record.setWDSP( newAll ); }
					else if( record.getMissing().equals( "PRCP" ) )   { record.setPRCP( newAll ); }
					else if( record.getMissing().equals( "SNDP" ) )   { record.setSNDP( newAll ); }
					else if( record.getMissing().equals( "FRSHTT" ) ) { record.setFRSHTT( (int) newAll ); }
					else if( record.getMissing().equals( "CLDC" ) )   { record.setCLDC( newAll ); }
					else if( record.getMissing().equals( "WNDDIR" ) ) { record.setWNDDIR( (int) newAll ); }

					//System.out.println(record.getSTN() + "/" + record.getTIME() + "/" + newAll + "/-/" + lastAll + "/-/" + counterAll);
				}
			}
		}

		cache.add( record );

		// Add to insert batch
		this.database.insert( record );
	}
}
