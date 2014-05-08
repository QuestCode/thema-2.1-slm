package runner;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import lt1.Server;

public class ReaderTester {

	public static void main( String[] args ) throws UnknownHostException, IOException {
		Socket socket;

	    String str    = "";
		Server reader = new Server();
		Thread t      = new Thread( reader );

		t.start();

	    socket = new Socket( InetAddress.getLocalHost(), 7789 );
	    str    = "<?xml version=\"1.0\"?>" +
			"<WEATHERDATA><MEASUREMENT>" +
			"<STN>123456</STN>" +
			"<DATE>2009-09-13</DATE>" +
			"<TIME>15:59:46</TIME>" +
			"<TEMP>-60.1</TEMP>" +
			"<DEWP>-58.1</DEWP>" +
			"<STP>1034.5</STP>" +
			"<SLP>1007.6</SLP>" +
			"<VISIB>123.7</VISIB>" +
			"<WDSP>10.8</WDSP>" +
			"<PRCP>11.28</PRCP>" +
			"<SNDP>11.1</SNDP>" +
			"<FRSHTT>010101</FRSHTT>" +
			"<CLDC>87.4</CLDC>" +
			"<WNDDIR>342</WNDDIR>" +
			"</MEASUREMENT></WEATHERDATA>";

	    ObjectOutputStream oos = new ObjectOutputStream( socket.getOutputStream() );

	    oos.writeObject( str );

	    oos.close();
	    socket.close();
	}

}
