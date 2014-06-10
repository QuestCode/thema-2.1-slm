/**
 * Created by Yuri on 13/5/2014.
 */

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class MongoDatabaseConnection {
    private static final String hostname = "127.0.0.1";
    private static final int port = 27017;

    private static final Boolean verifySTN = false;

    private DB db;
    private DBCollection stations;
    private DBCollection measurements;

    private int docsCounter = 0;

    //HashMap<String, MessageCorrector> messageCorrectors = new HashMap<String,MessageCorrector>();
    MessageCorrector[] messageCorrectors = new MessageCorrector[9959300];

    MessageCounter counter;

    public MongoDatabaseConnection(MessageCounter counter){
        try{
            MongoClient mongoClient = new MongoClient(hostname, port);

            db = mongoClient.getDB("UNWDMI");

            this.stations = db.getCollection("stations");
            this.measurements = db.getCollection("measurements");
        } catch (UnknownHostException e){
            System.out.println("Could not connect to MongoDB on " + hostname + ":" + port);
        }

        this.counter = counter;
        if(this.stations != null && this.measurements != null && this.db != null){
            System.out.println("Database connection to " + hostname + ":" + port + " established.");
        }
    }

    public void sendToServer(Message message){
        MessageCorrector messageCorrector;

        try{
            // Get station number from the message.
            int STN = Integer.parseInt(message.getValue("STN"));

            // Check for valid station number if this flag was set
            if(verifySTN){
                if(stations.findOne(new BasicDBObject("stn", STN)) == null){
                    System.out.println("Station not found");
                    return;
                }
            }

            if(this.messageCorrectors[STN] == null){
                messageCorrector = new MessageCorrector(message.getValue("STN"));
                messageCorrectors[STN] = messageCorrector;
            } else {
                messageCorrector = messageCorrectors[STN];
            }

            // If the message is incomplete, let the messagecorrector fix it.
            if(message.isComplete() == false){
                message = messageCorrector.correctMessage(message);
            }

            // Compare to previous message and run correction on temperature if necessary.
            message = messageCorrector.correctTemperature(message);

            // if something went wrong with the message corrector, stop.
            if(message == null || message.isComplete() == false){
                return;
            }

            // Add message to messageCorrector and DBObject to buffer.
            messageCorrector.addMessage(message);

            // Insert document into mongodb if we have MAX_DOCS_BUFFER amount of messages.
            BasicDBObject messageDBObject = message.getMongoDBObject();
            measurements.insert(messageDBObject);

        } catch (Exception e){
            System.out.println("Error inserting message: " + e.getMessage());
        }
    }
}
