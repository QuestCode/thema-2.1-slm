import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Yuri on 8/5/2014.
 */
public class ClusterConnection implements Runnable {
    Socket client;
    customInputStreamReader customInputStreamReader;
    public DatabaseConnection databaseConnection;

    public ClusterConnection(Socket client, DatabaseConnection databaseConnection){
        this.client = client;
        this.databaseConnection = databaseConnection;

        try
        {
            this.customInputStreamReader = new customInputStreamReader(client.getInputStream());
        } catch (Exception e){

        }
    }

    public void run(){
        Message[] messages;

        while(true){
            customInputStreamReader.receiveMessage();
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

        private void receiveMessage(){
            Message message = new Message();
            int weatherdataCount = 0;

            try{
                while(true){
                    line = bufferedReader.readLine();
                    message.addValue(line);

                    if(line.contains("</MEASUREMENT>")){
                        databaseConnection.sendMeasurementToServer(message);
                        message = new Message();
                        weatherdataCount++;

                        if(weatherdataCount > 10){
                            return;
                        }
                    }
                }

            } catch (Exception e){
            }
            return;
        }
    }
}