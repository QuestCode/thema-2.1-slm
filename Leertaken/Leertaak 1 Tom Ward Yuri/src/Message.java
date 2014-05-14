import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuri on 13/5/2014.
 */
public class Message {
    private HashMap<String, String> valuesMap = new HashMap<String, String>();

    public Message(){
    }

    public void addValue(String line){
        if(line.contains("WEATHERDATA") || line.contains("MEASUREMENT") || line.contains("?xml")){
            return;
        }

        String value = stripValue(line);
        String name = stripName(line);

        if(value != "" && name != ""){
            valuesMap.put(name, value);
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
        return this.valuesMap.get(name);
    }

    public String toString(){
        return  "\nSTN:   " + this.getValue("STN") +
                "\nDATE:  " + this.getValue("DATE") +
                "\nTIME:  " + this.getValue("TIME") +
                "\nTEMP:  " + this.getValue("TEMP") +
                "\nDEWP:  " + this.getValue("DEWP") +
                "\nSTP:   " + this.getValue("STP") +
                "\nSLP:   " + this.getValue("SLP") +
                "\nVISIB: " + this.getValue("VISIB") +
                "\nWDSP:  " + this.getValue("WDSP") +
                "\nPRCP:  " + this.getValue("PRCP") +
                "\nSNDP:  " + this.getValue("SNDP") +
                "\nFRSHTT:" + this.getValue("FRSHTT") +
                "\nCLDC:  " + this.getValue("CLDC") +
                "\nWNDDIR:" + this.getValue("WNDDIR");

    }

    public String getInsertQuery(){
        return "INSERT INTO measurements VALUES(" +
                this.getValue("STN") + ", '" +
                this.getValue("DATE") + "', '" +
                this.getValue("TIME") + "', " +
                this.getValue("TEMP") + ", " +
                this.getValue("DEWP") + ", " +
                this.getValue("STP") + ", " +
                this.getValue("SLP") + ", " +
                this.getValue("VISIB") + ", " +
                this.getValue("WDSP") + ", " +
                this.getValue("PRCP") + ", " +
                this.getValue("SNDP") + ", " +
                this.getValue("FRSHTT") + ", " +
                this.getValue("CLDC") + ", " +
                this.getValue("WNDDIR") +
                ")";
    }

    public Boolean isComplete(){
        for(Map.Entry<String, String> entry : this.valuesMap.entrySet()){
            if(entry.getValue() == "" || entry.getValue() == null || entry.getValue().isEmpty()){
                return false;
            }
        }
        return true;
    }

    public String[] getEmptyFieldNames(){
        ArrayList<String> emptyFields = new ArrayList<String>();

        for(Map.Entry<String, String> entry: this.valuesMap.entrySet()){
            if(entry.getValue() == "" || entry.getValue() == null || entry.getValue().isEmpty()){
                emptyFields.add(entry.getKey());
            }
        }

        return emptyFields.toArray(new String[emptyFields.size()]);
    }

    public void updateValue(String fieldName, String value){
        if(this.valuesMap.containsKey(fieldName)){
            this.valuesMap.remove(fieldName);
        }
        this.valuesMap.put(fieldName, value);
    }
}
