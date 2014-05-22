/**
 * Created by Yuri on 15/5/2014.
 */
public class MessageCounter {
    private int counter = 0;
    private static final Boolean PRINT_COUNT = true;

    public MessageCounter(){

    }

    public void increment(){
        synchronized(this) {
            this.counter++;
            if(PRINT_COUNT){
                System.out.println(this.counter);
            }
        }
    }
}
