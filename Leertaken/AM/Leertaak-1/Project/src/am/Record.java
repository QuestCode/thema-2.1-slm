package lt1;

import java.sql.SQLException;
import java.util.ArrayList;

public class Record implements Runnable
{
	/**
	 * Variables
	 *******************************************************/
	private Corrector corrector;

	private Integer STN;
	private String  DATE;
	private String  TIME;
	private Double  TEMP;
	private Double  DEWP;
	private Double  STP;
	private Double  SLP;
	private Double  VISIB;
	private Double  WDSP;
	private Double  PRCP;
	private Double  SNDP;
	private Integer FRSHTT;
	private Double  CLDC;
	private Integer WNDDIR;

	/**
	 * Constructor(s)
	 *******************************************************/
	public Record( Corrector corrector )
	{
		this.corrector = corrector;
	}

	/**
	 * Getters
	 *******************************************************/
	public ArrayList<String> getMissing() {
		ArrayList<String> missing = new ArrayList<String>();

		if( this.TEMP   == null ) { missing.add( "TEMP"   ); }
		if( this.DEWP   == null ) { missing.add( "DEWP"   ); }
		if( this.STP    == null ) { missing.add( "STP"    ); }
		if( this.SLP    == null ) { missing.add( "SLP"    ); }
		if( this.VISIB  == null ) { missing.add( "VISIB"  ); }
		if( this.WDSP   == null ) { missing.add( "WDSP"   ); }
		if( this.PRCP   == null ) { missing.add( "PRCP"   ); }
		if( this.SNDP   == null ) { missing.add( "SNDP"   ); }
		if( this.FRSHTT == null ) { missing.add( "FRSHTT" ); }
		if( this.CLDC   == null ) { missing.add( "CLDC"   ); }
		if( this.WNDDIR == null ) { missing.add( "WNDDIR" ); }

		return missing;
	}

	public Integer getSTN()    { return this.STN;    }
	public String  getDATE()   { return this.DATE;   }
	public String  getTIME()   { return this.TIME;   }
	public Double  getTEMP()   { return this.TEMP;   }
	public Double  getDEWP()   { return this.DEWP;   }
	public Double  getSTP()    { return this.STP;    }
	public Double  getSLP()    { return this.SLP;    }
	public Double  getVISIB()  { return this.VISIB;  }
	public Double  getWDSP()   { return this.WDSP;   }
	public Double  getPRCP()   { return this.PRCP;   }
	public Double  getSNDP()   { return this.SNDP;   }
	public Integer getFRSHTT() { return this.FRSHTT; }
	public Double  getCLDC()   { return this.CLDC;   }
	public Integer getWNDDIR() { return this.WNDDIR; }

	public Object getProperty( String name ) {
		if( name.equals( "STN"    ) ) { return this.STN;    }
		if( name.equals( "DATE"   ) ) { return this.DATE;   }
		if( name.equals( "TIME"   ) ) { return this.TIME;   }
		if( name.equals( "TEMP"   ) ) { return this.TEMP;   }
		if( name.equals( "DEWP"   ) ) { return this.DEWP;   }
		if( name.equals( "STP"    ) ) { return this.STP;    }
		if( name.equals( "SLP"    ) ) { return this.SLP;    }
		if( name.equals( "VISIB"  ) ) { return this.VISIB;  }
		if( name.equals( "WDSP"   ) ) { return this.WDSP;   }
		if( name.equals( "PRCP"   ) ) { return this.PRCP;   }
		if( name.equals( "SNDP"   ) ) { return this.SNDP;   }
		if( name.equals( "FRSHTT" ) ) { return this.FRSHTT; }
		if( name.equals( "CLDC"   ) ) { return this.CLDC;   }
		if( name.equals( "WNDDIR" ) ) { return this.WNDDIR; }

		return null;
	}

	public String toString() {
		return
			"(" + this.STN    +  "," +
			"'" + this.DATE   + "'," +
			"'" + this.TIME   + "'," +
			"'" + this.TEMP   + "'," +
			"'" + this.DEWP   + "'," +
			"'" + this.STP    + "'," +
			"'" + this.SLP    + "'," +
			"'" + this.VISIB  + "'," +
			"'" + this.WDSP   + "'," +
			"'" + this.PRCP   + "'," +
			"'" + this.SNDP   + "'," +
				+ this.FRSHTT +  "," +
			"'" + this.CLDC   + "'," +
				+ this.WNDDIR +  ")";
	}

	/**
	 * Setters
	 *******************************************************/
	public void setSTN    ( Integer v ) { this.STN    = v; }
	public void setDATE   ( String  v ) { this.DATE   = v; }
	public void setTIME   ( String  v ) { this.TIME   = v; }
	public void setTEMP   ( Double  v ) { this.TEMP   = v; }
	public void setDEWP   ( Double  v ) { this.DEWP   = v; }
	public void setSTP    ( Double  v ) { this.STP    = v; }
	public void setSLP    ( Double  v ) { this.SLP    = v; }
	public void setVISIB  ( Double  v ) { this.VISIB  = v; }
	public void setWDSP   ( Double  v ) { this.WDSP   = v; }
	public void setPRCP   ( Double  v ) { this.PRCP   = v; }
	public void setSNDP   ( Double  v ) { this.SNDP   = v; }
	public void setFRSHTT ( Integer v ) { this.FRSHTT = v; }
	public void setCLDC   ( Double  v ) { this.CLDC   = v; }
	public void setWNDDIR ( Integer v ) { this.WNDDIR = v; }

	public void setProperty( String name, Object v ) {
		if     ( name.equals( "STN"    ) ) { this.STN    = (Integer) v; }
		else if( name.equals( "DATE"   ) ) { this.DATE   = (String)  v; }
		else if( name.equals( "TIME"   ) ) { this.TIME   = (String)  v; }
		else if( name.equals( "TEMP"   ) ) { this.TEMP   = (Double)  v; }
		else if( name.equals( "DEWP"   ) ) { this.DEWP   = (Double)  v; }
		else if( name.equals( "STP"    ) ) { this.STP    = (Double)  v; }
		else if( name.equals( "SLP"    ) ) { this.SLP    = (Double)  v; }
		else if( name.equals( "VISIB"  ) ) { this.VISIB  = (Double)  v; }
		else if( name.equals( "WDSP"   ) ) { this.WDSP   = (Double)  v; }
		else if( name.equals( "PRCP"   ) ) { this.PRCP   = (Double)  v; }
		else if( name.equals( "SNDP"   ) ) { this.SNDP   = (Double)  v; }
		else if( name.equals( "FRSHTT" ) ) { this.FRSHTT = (Integer) v; }
		else if( name.equals( "CLDC"   ) ) { this.CLDC   = (Double)  v; }
		else if( name.equals( "WNDDIR" ) ) { this.WNDDIR = ( v instanceof Double ? ( (Double) v ).intValue() : (Integer) v ); }
		else { throw new RuntimeException( "Record has no property '" + name + "'." ); }
	}

	/**
	 * Runnable implementation
	 *******************************************************/
	public void run() {
		// Validate and insert
		try {
			this.corrector.validateAndInsert( this );
		}
		catch( SQLException e ) {
			e.printStackTrace();
		}
	}
}
