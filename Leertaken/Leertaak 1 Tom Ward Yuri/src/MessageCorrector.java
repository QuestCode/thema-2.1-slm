import java.util.ArrayList;

/**
 * Created by Yuri on 14/5/2014.
 */
public class MessageCorrector {
    public String STN;
    ArrayList<Message> oldMessages = new ArrayList<Message>();

    public MessageCorrector(String stn){
        this.STN = stn;
    }

    public void addMessage(Message message){
        if(oldMessages.size() >= 30){
            oldMessages.remove(0);
        }

        oldMessages.add(message);
    }

    public Message correctMessage(Message message){
        String[] emptyFieldNames = message.getEmptyFieldNames();

        if(this.oldMessages.size() < 2){
            for(int i = 0; i < emptyFieldNames.length; i++){
                message.updateValue(emptyFieldNames[i], "0");
            }

            return message;
        }

        for(int i = 0; i < emptyFieldNames.length; i++){
            message.updateValue(emptyFieldNames[i], this.getPredictedValue(emptyFieldNames[i]));
            System.out.println("Got extrapolated value for: " + emptyFieldNames[i]);
        }
        return message;
    }

    public Message correctTemperature(Message message){
        if(this.oldMessages.size() < 2){
            return message;
        }

        Double messageTemp = Double.parseDouble(message.getValue("TEMP"));
        Double expectedTemp = Double.parseDouble(getPredictedValue("TEMP"));

        if(messageTemp < expectedTemp * 0.8 || messageTemp > expectedTemp * 1.2){
            message.updateValue("TEMP", Double.toString(Math.floor(expectedTemp)));
        }
        return message;
    }

    private String getPredictedValue(String fieldName){
        if(fieldName == "TIME" || fieldName == "DATE"){
            return "";
        }

        if(fieldName == "FRSHTT"){
            return oldMessages.get(oldMessages.size()).getValue(fieldName);
        }

        // Check what changed during the previous 2 values
        double predictedChange = Double.parseDouble(oldMessages.get(oldMessages.size() - 2).getValue(fieldName)) - Double.parseDouble(oldMessages.get(oldMessages.size() - 1).getValue(fieldName));

        return Double.toString(Double.parseDouble(oldMessages.get(oldMessages.size() - 1).getValue(fieldName)) + predictedChange);
    }

    private double getAverageDeviation(String fieldName){
        double average = 0.0;

        // Get average value
        double total = 0.0;
        for(int i = 0; i < oldMessages.size() - 1; i++){
            total += (Double.parseDouble(oldMessages.get(i).getValue(fieldName)));
        }

        average = total / oldMessages.size();

        double totalDeviation = 0.0;
        for(int i = 0; i < oldMessages.size() - 1; i++){
            totalDeviation += (Double.parseDouble(oldMessages.get(i).getValue(fieldName)) - average);
        }

        return totalDeviation / oldMessages.size();
    }
}
