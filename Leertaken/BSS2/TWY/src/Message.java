import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuri on 13/5/2014.
 */
public class Message {
    private String[] values = new String[14];

    public Message(){
    }

    public void addValue(String line){
        if(line.contains("WEATHERDATA") || line.contains("MEASUREMENT") || line.contains("?xml")){
            return;
        }

        String value = stripValue(line);
        String name = stripName(line);

        if(value != "" && name != ""){
            putValueString(name, value);
        }
    }

    private String stripValue(String value){
        return value.substring(value.indexOf( '>' ) + 1, value.lastIndexOf( '<' ) );
    }

    private String stripName(String value)
    {
        return value.substring(value.indexOf( '<' ) + 1, value.indexOf( '>' ) );
    }

    public String getValue(String name){
        return this.values[getIndexForName(name)];
    }

    public String getValue(int index){
        return this.values[index];
    }

    public String toString(){
        return  "\nSTN:   " + this.values[0] +
                "\nDATE:  " + this.values[1] +
                "\nTIME:  " + this.values[2] +
                "\nTEMP:  " + this.values[3] +
                "\nDEWP:  " + this.values[4] +
                "\nSTP:   " + this.values[5] +
                "\nSLP:   " + this.values[6] +
                "\nVISIB: " + this.values[7] +
                "\nWDSP:  " + this.values[8] +
                "\nPRCP:  " + this.values[9] +
                "\nSNDP:  " + this.values[10] +
                "\nFRSHTT:" + this.values[11] +
                "\nCLDC:  " + this.values[12] +
                "\nWNDDIR:" + this.values[13];

    }

    public String getInsertQuery(){
        return "INSERT INTO measurements VALUES(" +
                this.values[0] + ", '" +
                this.values[1] + "', '" +
                this.values[2] + "', " +
                this.values[3] + ", " +
                this.values[4] + ", " +
                this.values[5] + ", " +
                this.values[6] + ", " +
                this.values[7] + ", " +
                this.values[8] + ", " +
                this.values[9] + ", " +
                this.values[10] + ", " +
                this.values[11] + ", " +
                this.values[12] + ", " +
                this.values[13] + ")";
    }

    public Boolean isComplete(){
        for(int i = 0; i < this.values.length; i++){
            if(values[i] == null || this.values[i] == ""){
                return false;
            }
        }
        return true;
    }

    public int[] getEmptyFieldIndexes(){
        ArrayList<Integer> emptyFields = new ArrayList<Integer>();

        for(int i = 0; i < this.values.length; i++){
            if(this.values[i] == null || this.values[i] == "") {
                emptyFields.add(i);
            }
        }

        // Convert Integer List to int[]
        int returnArray[] = new int[emptyFields.size()];
        for(int i = 0; i < emptyFields.size(); i++){
            returnArray[i] = emptyFields.get(i);
        }

        return returnArray;
    }

    public int getIndexForName(String name){
        int index = 0;

        index =         (name.equals("STN")) ? 0 :
                        (name.equals("DATE")) ? 1 :
                        (name.equals("TIME")) ? 2 :
                        (name.equals("TEMP")) ? 3 :
                        (name.equals("DEWP")) ? 4 :
                        (name.equals("STP")) ? 5 :
                        (name.equals("SLP")) ? 6 :
                        (name.equals("VISIB")) ? 7 :
                        (name.equals("WDSP")) ? 8 :
                        (name.equals("PRCP")) ? 9 :
                        (name.equals("SNDP")) ?  10 :
                        (name.equals("FRSHTT")) ? 11 :
                        (name.equals("CLDC")) ? 12 :
                        (name.equals("WNDDIR")) ? 13 : index;

        return index;
    }

    public void putValueString(String name, String value){
        this.values[getIndexForName(name)] = value;

    }

    public void putValue(int index, String value){
        this.values[index] = value;
    }
}
