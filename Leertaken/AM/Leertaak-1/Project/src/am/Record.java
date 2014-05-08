package lt1;

import java.sql.SQLException;

public class Record implements Runnable
{
	/**
	 * Variables
	 *******************************************************/
	private Corrector corrector;

	private int     STN;
	private String  DATE;
	private String  TIME;
	private double  TEMP;
	private double  DEWP;
	private double  STP;
	private double  SLP;
	private double  VISIB;
	private double  WDSP;
	private double  PRCP;
	private double  SNDP;
	private int     FRSHTT;
	private double  CLDC;
	private int     WNDDIR;
	private String  missing;

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
	public int     getSTN()     { return this.STN;     }
	public String  getDATE()    { return this.DATE;    }
	public String  getTIME()    { return this.TIME;    }
	public double  getTEMP()    { return this.TEMP;    }
	public double  getDEWP()    { return this.DEWP;    }
	public double  getSTP()     { return this.STP;     }
	public double  getSLP()     { return this.SLP;     }
	public double  getVISIB()   { return this.VISIB;   }
	public double  getWDSP()    { return this.WDSP;    }
	public double  getPRCP()    { return this.PRCP;    }
	public double  getSNDP()    { return this.SNDP;    }
	public int     getFRSHTT()  { return this.FRSHTT;  }
	public double  getCLDC()    { return this.CLDC;    }
	public int     getWNDDIR()  { return this.WNDDIR;  }
	public String  getMissing() { return this.missing; }

	public String getQuery()
	{
		return
			"(" + STN    +  "," +
			"'" + DATE   + "'," +
			"'" + TIME   + "'," +
			"'" + TEMP   + "'," +
			"'" + DEWP   + "'," +
			"'" + STP    + "'," +
			"'" + SLP    + "'," +
			"'" + VISIB  + "'," +
			"'" + WDSP   + "'," +
			"'" + PRCP   + "'," +
			"'" + SNDP   + "'," +
				+ FRSHTT +  "," +
			"'" + CLDC   + "'," +
				+ WNDDIR +  ")";
	}

	/**
	 * Setters
	 *******************************************************/
	public void setSTN     ( int v )    { this.STN     = v; }
	public void setDATE    ( String v ) { this.DATE    = v; }
	public void setTIME    ( String v ) { this.TIME    = v; }
	public void setTEMP    ( double v ) { this.TEMP    = v; }
	public void setDEWP    ( double v ) { this.DEWP    = v; }
	public void setSTP     ( double v ) { this.STP     = v; }
	public void setSLP     ( double v ) { this.SLP     = v; }
	public void setVISIB   ( double v ) { this.VISIB   = v; }
	public void setWDSP    ( double v ) { this.WDSP    = v; }
	public void setPRCP    ( double v ) { this.PRCP    = v; }
	public void setSNDP    ( double v ) { this.SNDP    = v; }
	public void setFRSHTT  ( int v )    { this.FRSHTT  = v; }
	public void setCLDC    ( double v ) { this.CLDC    = v; }
	public void setWNDDIR  ( int v )    { this.WNDDIR  = v; }
	public void setMissing ( String v ) { this.missing = v; }

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
