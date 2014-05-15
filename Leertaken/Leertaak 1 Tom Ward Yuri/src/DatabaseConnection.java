/**
 * Created by Yuri on 13/5/2014.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;

public class DatabaseConnection {
    private static final String hostname = "jdbc:postgresql://95.85.63.58:5432/one";
    private static final String username = "one";
    private static final String password = "Tr3ll0?";

    private Connection databaseConnection;

    HashMap<String, MessageCorrector> messageCorrectors = new HashMap<String,MessageCorrector>();

    public DatabaseConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e){
            System.out.println("Class not found");
        }

        try {
            databaseConnection = DriverManager.getConnection(hostname, username, password);
            System.out.println("Database connection established");
            sendMeasurementToServer(new Message());

        } catch (Exception e){
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    public void sendMeasurementToServer(Message message){
        String query = "";
        MessageCorrector messageCorrector;
        Message message1 = message;

        try {
            Statement statement = databaseConnection.createStatement();

            // Get the message corrector for the current station or create a new one.
            if(!this.messageCorrectors.containsKey(message.getValue("STN"))){
                messageCorrector = new MessageCorrector(message.getValue("STN"));
                messageCorrectors.put(messageCorrector.STN, messageCorrector);
            } else {
                messageCorrector = messageCorrectors.get(message.getValue("STN"));
            }

            // If the message is incomplete, let the messagecorrecter correct it.
            if(message.isComplete() == false){
                message = messageCorrector.correctMessage(message);
            }

            // Compare to previous message and run correction
            message = messageCorrector.correctTemperature(message);
            query = message.getInsertQuery();
            messageCorrector.addMessage(message);
            statement.executeQuery(query);
        } catch (Exception e){
            //System.out.println(e.getMessage() + " " + e.getStackTrace());
        }
    }

    public void sendMeasurementsToServer(Message[] messages){
        for(int i = 0; i < messages.length; i++){
            sendMeasurementToServer(messages[i]);
        }
    }
}
