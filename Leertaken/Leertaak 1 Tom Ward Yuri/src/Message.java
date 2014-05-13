import java.util.HashMap;

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
}
