import java.lang.reflect.Array;

/**
 * Created by Yuri on 19/5/2014.
 */
public class BankImpl implements Bank {
    private Customer[] customers = new Customer[Customer.COUNT];
    private int[] resources;

    private int[][] allocated;
    private int[][] maxDemand;

    public BankImpl(int[] resources){
        this.resources = resources;
        this.maxDemand = new int[Customer.COUNT][resources.length];
        this.allocated = new int[Customer.COUNT][resources.length];
    }

    /**
     * Add a customer to the bank.
     * @param threadNum The number of the customer being added.
     * @param maxDemand The maximum demand for this customer.
     */
    public void addCustomer(int threadNum, int[] maxDemand){
        this.customers[threadNum] = new Customer(threadNum, maxDemand, this);
        this.maxDemand[threadNum] = maxDemand;
    }

    /**
     * Outputs the available, allocation, max, and need matrices.
     */
    public void getState(){
        StringBuilder sb = new StringBuilder();

        // Append available
        sb.append("\n\nAvailable:\n----------\n");
        for(int i = 0; i < resources.length; i++){
            sb.append("Resource " + i + ": " + resources[i] + "\n");
        }

        // Append allocated
        sb.append("\n\nAllocated:\n----------\n");
        for(int i = 0; i < allocated[Customer.COUNT].length; i++){
            // Sum of all allocated resources
            int sum = 0;

            for(int j = 0; j < allocated.length; j++){
                sum += allocated[j][i];
            }

            sb.append("Resource " + i + ": " + sum + "\n");
        }

        // Append max
        sb.append("\n\nMax demand:\n----------");
        for(int i = 0; i < maxDemand.length; i++){
            sb.append("\nCustomer " + i + ": ");

            // Append individual resources to line.
            for(int j = 0; j < maxDemand[i].length; j++){
                sb.append(" Resource " + j + ": " + maxDemand[i][j]);
            }
        }

        // Append need
        sb.append("\n\nNeed:\n----------");
        for(int i = 0; i < maxDemand.length; i++){
            sb.append("\nCustomer " + i + ": ");

            for(int j = 0; j < maxDemand[i].length; j++){
                sb.append(" Resource " + j + ": " + (maxDemand[i][j] - allocated[i][j]));
            }
        }

        // Print everything in one go.
        System.out.println(sb);
    }

    /**
     * Make a request for resources.
     * @param threadNum The number of the customer being added.
     * @param request The request for this customer.
     * @return  true The request is granted.
     * @return  false The request is not granted.
     */
    public boolean requestResources(int threadNum, int[] request){
        // Check if we allow this request to be processed.
        for(int i = 0; i < request.length; i++){
            // Decline request if it does not leave the system in safe state.
            if(request[i] > resources[i]){
                return false;
            }

            // Decline request if request is more than the max demand for that customer
            if(request[i] > maxDemand[threadNum][i]){
                return false;
            }
        }

        // Process request and return true
        for(int i = 0; i < request.length; i++){
            resources[i] -= request[i];
            allocated[threadNum][i] += request[i];
        }

        return true;
    }

    /**
     * Release resources.
     * @param threadNum The number of the customer being added.
     * @param release The resources to be released.
     */
    public  void releaseResources(int threadNum, int[] release){
        // Release resources
        for(int i = 0; i < release.length; i++){
            resources[i] += release[i];
            allocated[threadNum][i] -= release[i];
        }
    }
}
