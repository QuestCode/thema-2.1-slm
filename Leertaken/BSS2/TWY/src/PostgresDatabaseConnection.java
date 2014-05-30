/**
 * Created by Yuri on 13/5/2014.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PostgresDatabaseConnection {
    private static final String hostname = "jdbc:postgresql://127.0.0.1:5432/one";
    private static final String username = "one";
    private static final String password = "Tr3ll0?";

    private Connection databaseConnection;

    //HashMap<String, MessageCorrector> messageCorrectors = new HashMap<String,MessageCorrector>();
    MessageCorrector[] messageCorrectors = new MessageCorrector[9959300];

    MessageCounter counter;

    public PostgresDatabaseConnection(MessageCounter counter){
        this.counter = counter;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e){
            System.out.println("Class not found");
        }

        try {
            databaseConnection = DriverManager.getConnection(hostname, username, password);
            System.out.println("Database connection established");

        } catch (Exception e){
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    public void sendToServer(Message message){
        String query = "";
        MessageCorrector messageCorrector;

        try {
            Statement statement = databaseConnection.createStatement();

            // Get the message corrector for the current station or create a new one.
            int STN = Integer.parseInt(message.getValue("STN"));
            if(this.messageCorrectors[STN] == null){
                messageCorrector = new MessageCorrector(message.getValue("STN"));
                messageCorrectors[STN] = messageCorrector;
            } else {
                messageCorrector = messageCorrectors[STN];
            }

            // If the message is incomplete, let the messagecorrecter correct it.
            if(message.isComplete() == false){
                message = messageCorrector.correctMessage(message);
            }

            // Compare to previous message and run correction
            message = messageCorrector.correctTemperature(message);
            if(message == null){return;}
            query = message.getInsertQuery();
            messageCorrector.addMessage(message);
            statement.executeQuery(query);
        } catch (Exception e){
            //System.out.println(e.getMessage());
        }
    }
}
