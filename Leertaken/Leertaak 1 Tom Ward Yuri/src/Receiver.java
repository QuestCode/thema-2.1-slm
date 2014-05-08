import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Yuri on 8/5/2014.
 */
public class Receiver {
    public Receiver(int port, int threadsPerPool, int maxPools){
        try{
            int threadsInCurrentPool = 0;
            int currentPool = 0;

            ServerSocket socket = new ServerSocket(port);
            Socket client = null;

            // Create threadpools
            ExecutorService[] threadPools = new ExecutorService[maxPools];

            System.out.println("Receiver running with " + maxPools + " thread pools");

            while(true){
                // Accept client and assign to thread
                client = socket.accept();

                System.out.println("Client accepted");

                if(threadsInCurrentPool < threadsPerPool){
                    if(threadPools[currentPool] == null){
                        threadPools[currentPool] = Executors.newFixedThreadPool(threadsPerPool);
                    }

                    threadPools[currentPool].submit(new Connection(client));
                    threadsInCurrentPool++;
                } else {
                    threadsInCurrentPool = 0;
                    currentPool++;
                }
            }
        } catch (Exception e){

        }
    }
}
