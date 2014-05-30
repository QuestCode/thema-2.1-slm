/**
 * Created by Yuri on 14/5/2014.
 */
public class MessageCorrector {
    public String STN;
    Message[] oldMessages = new Message[30];
    private int counter = 0;

    public MessageCorrector(String stn){
        this.STN = stn;
    }

    public void addMessage(Message message){
        if(counter == 30){
            counter = 0;
        }

        oldMessages[counter] = message;

        counter++;
    }

    public Message correctMessage(Message message){
        if(getAmountofOldMessages() <= 2){
            //System.out.println("Could not extrapolate because we have no messages");
            return null;
        }

        int[] emptyFieldIndexes = message.getEmptyFieldIndexes();

        for(int i = 0; i < emptyFieldIndexes.length; i++){
            message.putValue(emptyFieldIndexes[i], this.getExtrapolatedValue(emptyFieldIndexes[i]));
            //System.out.println("Got extrapolated value for: " + emptyFieldIndexes[i]);
        }
        return message;
    }

    public Message correctTemperature(Message message){
        if(getAmountofOldMessages() <= 2){
            //System.out.println("Could not extrapolate because we have no messages");
            return message;
        }

        Double messageTemp = Double.parseDouble(message.getValue("TEMP"));
        Double extrapolatedTemp = Double.parseDouble(getExtrapolatedValue(3));

        if(messageTemp < extrapolatedTemp * 0.8 || messageTemp > extrapolatedTemp * 1.2){
            message.putValue(3, Double.toString(extrapolatedTemp));
        }
        return message;
    }

    private String getExtrapolatedValue(int fieldIndex){
        Double totalDeviation = 0.0;

        if(fieldIndex == 1 || fieldIndex == 2){
            System.out.println("Cannot extrapolate date/time");
            return "";
        }

        int amountOfOldMessages = getAmountofOldMessages();

        for(int i = 0; i < amountOfOldMessages - 1; i++){
            totalDeviation += (Double.parseDouble(oldMessages[i + 1].getValue(fieldIndex)) - Double.parseDouble(oldMessages[i].getValue(fieldIndex)));
        }

        Double deviation = totalDeviation / amountOfOldMessages;
        Double extrapolatedValue = (Double.parseDouble(oldMessages[amountOfOldMessages - 1].getValue(fieldIndex)) + deviation);

        if(extrapolatedValue != 0){
            return Double.toString(Math.floor(extrapolatedValue));
        } else{
            return "0";
        }
    }

    private int getAmountofOldMessages(){
        int counter = 0;

        for(int i = 0; i < oldMessages.length; i++){
            if(oldMessages[i] != null) {
                counter++;
            }
        }

        return counter;
    }
}
