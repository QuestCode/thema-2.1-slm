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

    public Connection(Socket client){
        this.client = client;

        try
        {
            this.customInputStreamReader = new customInputStreamReader(client.getInputStream());
        } catch (Exception e){

        }
    }

    public void run(){
        String line;

        while((line = customInputStreamReader.receiveString()) != null){
            String time = getValue("TIME", line);
            if(time != null){
                System.out.println(time);
            }
        }
    }

    private String getValue(String xmlName, String message){


        /* REGEX APPROACH
        Pattern regex = Pattern.compile("<" + xmlName + ">(.*?)</" + xmlName + ">", Pattern.DOTALL);
        Matcher matcher = regex.matcher(message);
        if (matcher.find()) {
            if(xmlName == "TIME"){
                Pattern regex2 = Pattern.compile("[0-9][0-9]:|[0-9][0-9]");
                Matcher matcher2 = regex2.matcher(matcher.group());

                return matcher2.group();
            }

            return matcher.group();
        }
        return null;*/
    }

private class customInputStreamReader {
    InputStream inputStream;
    BufferedReader bufferedReader = null;
    StringBuilder stringBuilder = new StringBuilder();
    String line;

        public customInputStreamReader(InputStream inputStream){
            this.inputStream = inputStream;
            this.bufferedReader = new BufferedReader(new InputStreamReader(this.inputStream));
        }

        private String receiveString(){
            try{
                while((line = bufferedReader.readLine()) != null){
                    return line;
                }

            } catch (Exception e){

            }
            return null;
        }
    }
}
