import com.sun.org.apache.xpath.internal.jaxp.XPathFactoryImpl;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yuri on 8/5/2014.
 */
public class Connection implements Runnable {
    Socket client;
    customInputStreamReader customInputStreamReader;
    DatabaseConnection databaseConnection;

    public Connection(Socket client, DatabaseConnection databaseConnection){
        this.client = client;
        this.databaseConnection = databaseConnection;

        try
        {
            this.customInputStreamReader = new customInputStreamReader(client.getInputStream());
        } catch (Exception e){

        }
    }

    public void run(){
        Message message;

        while((message = customInputStreamReader.receiveMessage()) != null){
            System.out.println(message.toString());
        }
    }

private class customInputStreamReader {
    InputStream inputStream;
    BufferedReader bufferedReader = null;
    String line;

        public customInputStreamReader(InputStream inputStream){
            this.inputStream = inputStream;
            this.bufferedReader = new BufferedReader(new InputStreamReader(this.inputStream));
        }

        private Message receiveMessage(){
            Message message = new Message();

            try{
                while((line = bufferedReader.readLine()) != null){
                    message.addValue(line);

                    if(line.contains("</WEATHERDATA>")){
                        return message;
                    }
                }

            } catch (Exception e){
                System.out.println(e);
            }
            return null;
        }
    }
}
