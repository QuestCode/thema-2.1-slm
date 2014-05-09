package com.company;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        // See if there an argument for the hostname was given, if not, use google.com
	    String host = args.length < 1 ? "google.com" : args[0];
        OutputStream outputStream = null;

        try {
            // connect to server on localhost, port 6052
            Socket socket = new Socket("localhost", 6052);

            // Get input and output stream/writer
            InputStream inputStream = socket.getInputStream();
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");

            String received = "";

            // Write hostname to server
            writer.write(host + "\r\n");

            // Flush writer in case we'll use it again in the future (clears buffer)
            writer.flush();

            // Continuously check for received message from server. Output the received message and exit the program.
            while(true){
                if((received = getString(inputStream)) != ""){
                    System.out.println(received);
                    break;
                }
            }

        }
        catch (Exception ex){
            System.out.println("Exception: " + ex);
        }

    }

    /**
     * Get String from input stream
     * @param inputStream inputStream
     * @return a string with the contents of the next line in inputstream
     */
    private static String getString(InputStream inputStream){
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();

        String line;

        try{
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while((line = bufferedReader.readLine()) != null){
                return line;
            }
        } catch (Exception ex){

        }
        return "";
    }
}
