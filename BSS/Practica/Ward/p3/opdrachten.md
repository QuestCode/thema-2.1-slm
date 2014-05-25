# Practicum opdrachten week 3


**Exercise 1.1  There are three major methods for handling deadlock. (See Chapter 7.3.1). But actually there are four. Describe these four methods for handling deadlock.**

- Ignoring deadlock  
_In this approach, it is assumed that a deadlock will (almost) never occur. This is used when the time intervals between occurrences of deadlocks are large and the data loss incurred each time is tolerable._

- Detection  
_Under deadlock detection, deadlocks are allowed to occur. Then the state of the system is examined to detect that a deadlock has occurred and subsequently it is corrected._

- Prevention  
_Deadlock prevention works by preventing one of the four Coffman conditions from occurring._

- Avoidance  
_Deadlock can be avoided if certain information about processes are available to the operating system before allocation of resources, such as which resources a process will consume in its lifetime. For every resource request, the system sees whether granting the request will mean that the system will enter an unsafe state, meaning a state that could result in deadlock. The system then only grants requests that will lead to safe states._


**Exercise 1.2  Consider the following snapshot of a system. Answer the following questions using the banker's algorithm:**

**a. What is the content of the matrix Need?**  
The matrix need contains the remaining recources for each process. Need equals the process max recources - the allocated recources.

| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Allocation &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; |   | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Max &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; |   | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Need &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; |   | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Available &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; |
|----|---------------|---|---------------|---|---------------|---|---------------|

|	   | A | B | C | D |   | A | B | C | D |   | A | B | C | D |   | A | B | C | D |
|------|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
|      |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   | 1 | 5 | 2 | 0 |
| _P0_ | 0 | 0 | 1 | 2 |   | 0 | 0 | 1 | 2 |   | 0 | 0 | 0 | 0 |   |   |   |   |   |
| _P1_ | 1 | 0 | 0 | 0 |   | 1 | 7 | 5 | 0 |   | 0 | 7 | 5 | 0 |   |   |   |   |   |
| _P2_ | 1 | 3 | 5 | 4 |   | 2 | 3 | 5 | 6 |   | 1 | 0 | 0 | 2 |   |   |   |   |   |
| _P3_ | 0 | 6 | 3 | 2 |   | 0 | 6 | 5 | 2 |   | 0 | 0 | 2 | 0 |   |   |   |   |   |
| _P4_ | 0 | 0 | 1 | 4 |   | 0 | 6 | 5 | 6 |   | 0 | 6 | 4 | 2 |   |   |   |   |   |


**b. Is the system in a safe state?**  
Yes there are still enough recources for P0 or P3 to run.

**c. If a request from process P1 arrives for (0, 4, 2, 0), can the request be granted immediately?**  
Yes, now there is still 1,1,0,0 available. Which is enough for P0 to run.


**Exercise 1.3  Java’s locking mechanism (the synchronized statement) is considered reentrant. That is, if a thread acquires the lock for an object (byinvoking a synchronized method or block), it can 
enter other synchronized methods or blocks for the same object. Explain how deadlock would be possible if Java’s locking mechanism were not reentrant.**

This would allow deadlocks by acquiring a lock on a object then calling a method which also requires that object. The second would be blocked by the first and the first will never lose it lock.

##BankImpl.java

```java
import java.io.*;
import java.util.*;

/**
 * Created by Ward on 12-5-14.
 */
public class BankImpl implements Bank {

    private int[] resources;
    private Customer[] customers = new Customer[Customer.COUNT];

    private int[][] maximum;    // Maximum amount for each thread
    private int[][] allocation;    // The amount currently in use by each thread

    //private int[] available;    // Amount of available resources
    //private int[][] need;        // The remaining amount for each thread

    private int n;              // Threads
    private int m;              // Resources

    public BankImpl(int[] resources){
        this.resources = resources;

        n = Customer.COUNT;
        m = resources.length;

        this.maximum = new int[n][m];
        this.allocation = new int[n][m];
    }

    /**
     * Add a customer to the bank.
     * @param threadNum The number of the customer being added.
     * @param maximum The maximum demand for this customer.
     */
    public void addCustomer(int threadNum, int[] maximum){
        this.customers[threadNum] = new Customer(threadNum, maximum, this);
        this.maximum[threadNum] = maximum;
    }

    /**
     * Outputs the available, allocation, max, and need matrices.
     */
    public void getState(){
        StringBuilder sb = new StringBuilder();

        // Append available
        sb.append("\n\nAvailable:\n----------\n");
        for(int i = 0; i < m; i++){
            sb.append("Resource " + i + ": " + resources[i] + "\n");
        }

        // Append allocation
        sb.append("\n\nAllocated:\n----------\n");
        for(int i = 0; i < allocation[0].length; i++){
            // Sum of all allocation resources
            int sum = 0;

            for(int j = 0; j < allocation.length; j++){
                sum += allocation[j][i];
            }

            sb.append("Resource " + i + ": " + sum + "\n");
        }

        // Append max
        sb.append("\n\nMax demand:\n----------");
        for(int i = 0; i < maximum.length; i++){
            sb.append("\nCustomer " + i + ": ");

            // Append individual resources to line.
            for(int j = 0; j < maximum[i].length; j++){
                sb.append(maximum[i][j] + ", ");
            }
        }

        // Append need
        sb.append("\n\nNeed:\n----------");
        for(int i = 0; i < maximum.length; i++){
            sb.append("\nCustomer " + i + ": ");

            for(int j = 0; j < maximum[i].length; j++){
                sb.append(allocation[i][j] + ", ");
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
    public synchronized boolean requestResources(int threadNum, int[] request){
        // Check if we allow this request to be processed.
        for(int i = 0; i < request.length; i++){
            // Decline request if it does not leave the system in safe state.
            if(request[i] > resources[i]){
                return false;
            }

            // Decline request if request is more than the max demand for that customer
            if(request[i] > maximum[threadNum][i]){
                return false;
            }
        }

        // Check if it leaves the system in a safe state
        if(!isSafeState(threadNum, request)){
            return false;
        }

        // Process request and return true
        for(int i = 0; i < request.length; i++){
            resources[i] -= request[i];
            allocation[threadNum][i] += request[i];
        }

        return true;
    }

    /**
     * Release resources.
     * @param threadNum The number of the customer being added.
     * @param release The resources to be released.
     */
    public synchronized void releaseResources(int threadNum, int[] release){
        // Release resources
        for(int i = 0; i < release.length; i++){
            resources[i] += release[i];
            allocation[threadNum][i] -= release[i];
        }
        getState();
    }

        private boolean isSafeState( int customerNum, int[] request ) {
            // Determines if a state is safe by trying to find a hypothetical set of requests by the processes that would allow each to acquire its
            // maximum resources and then terminate (returning its resources to the system).
            // Any state where no such set exists is an unsafe state.
        int[] clonedResources = resources.clone();
        int[][] clonedAllocated = allocation.clone();

        // First check if any part of the request requires more resources than are available (unsafe state)
        for(int i = 0; i < clonedResources.length; i++){
            if(request[i] > clonedResources[i]){
                return false;
            }
        }

        // If we reach this point, the first request was valid so we execute it on the simulated resources
        for(int i = 0; i < clonedResources.length; i++){
            clonedResources[i] -= request[i];
            clonedAllocated[customerNum][i] += request[i];
        }

        // Create new boolean array and set all to false
        boolean[] canFinish = new boolean[customers.length];

        for(int i = 0; i < canFinish.length; i++){
            canFinish[i] = false;
        }

        // Now check if there is an order wherein other customers can still finish after us
        for(int i = 0; i < customers.length; i++){
            // Find a customer that can finish a request. Loop through all resources per customer
            for(int j = 0; j < customers.length; j++){
                if(!canFinish[j]){
                    boolean temp = true;
                    for(int k = 0; k < clonedResources.length; k++){
                        // If the need (maximum - allocation = need) is not bigger than the amount of available resources, thread can finish
                        if(!((maximum[j][k] - clonedAllocated[j][k]) > clonedResources[k])){
                            canFinish[j] = true;
                            for(int l = 0; l < clonedResources.length; l++){
                                clonedResources[l] += clonedAllocated[j][l];
                            }
                        }
                    }
                }
            }
        }

        // restore the value of need and allocation for this thread
        for (int i = 0; i < m; i++) {
            clonedAllocated[customerNum][i] -= request[i];
        }

        // After all the previous calculations. Loop through the array and see if every customer can complete the transaction for their maximum demand
        for(int i = 0; i < canFinish.length; i++){
            if(canFinish[i] == false){
                return false;
            }
        }

        return true;
    }
}
```