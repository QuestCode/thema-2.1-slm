import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        if(this.oldMessages.size() == 0){
            System.out.println("couldnt extrapolate because we have no messages");
            return message;
        }

        String[] emptyFieldNames = message.getEmptyFieldNames();

        for(int i = 0; i < emptyFieldNames.length; i++){
            message.updateValue(emptyFieldNames[i], this.getExtrapolatedValue(emptyFieldNames[i]));
            System.out.println("Got extrapolated value for: " + emptyFieldNames[i]);
        }
        return message;
    }

    public Message correctTemperature(Message message){
        if(this.oldMessages.size() == 0){
            System.out.println("couldnt extrapolate because we have no messages");
            return message;
        }

        Double messageTemp = Double.parseDouble(message.getValue("TEMP"));
        Double extrapolatedTemp = Double.parseDouble(getExtrapolatedValue("TEMP"));

        if(messageTemp < extrapolatedTemp * 0.8 || messageTemp > extrapolatedTemp * 1.2){
            message.updateValue("TEMP", Double.toString(extrapolatedTemp));
        }
        return message;
    }

    private String getExtrapolatedValue(String fieldName){
        Double totalDeviation = 0.0;

        if(fieldName == "TIME" || fieldName == "DATE"){
            System.out.println("Cannot extrapolate date/time");
            return "";
        }

        for(int i = 0; i < oldMessages.size() - 1; i++){
            totalDeviation += (Double.parseDouble(oldMessages.get(i + 1).getValue(fieldName)) - Double.parseDouble(oldMessages.get(i).getValue(fieldName)));
        }

        Double deviation = totalDeviation / oldMessages.size();
        Double extrapolatedValue = Double.parseDouble(oldMessages.get(oldMessages.size() - 1).getValue(fieldName)) + deviation;

        if(extrapolatedValue != 0){
            return Double.toString(Math.floor(extrapolatedValue));
        } else{
            return "0";
        }
    }
}
