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

```java
import java.io.*;
import java.util.*;

/**
 * Created by Ward on 12-5-14.
 */
public class BankImpl implements Bank {

    private int[] available;    // Amount of available resources
    private int[][] maximum;    // Maximum amount for each thread
    private int[][] allocation;    // The amount currently in use by each thread
    private int[][] need;        // The remaining amount for each thread

    private int n;              // Threads
    private int m;              // Resources

    public BankImpl(int[] resources) {

        int m = resources.length;
        int n = Customer.COUNT;

        available = new int[m];
        System.arraycopy(resources, 0, available, 0, m);

        maximum = new int[n][];
        allocation = new int[n][];
        need = new int[n][];
    }

    @Override
    public void addCustomer(int threadNum, int[] maxDemand) {

        maximum[threadNum] = new int[m];
        allocation[threadNum] = new int[m];
        need[threadNum] = new int[m];

        System.arraycopy(maxDemand, 0, maximum[threadNum], 0, maxDemand.length);
        System.arraycopy(maxDemand, 0, need[threadNum], 0, maxDemand.length);
    }

    @Override
    public void getState() {

        System.out.print("Available = ");
        for (int i = 0; i < m - 1; i++)
            System.out.print(available[i] + " ");

        System.out.println(available[m - 1]);
        System.out.print("\nAllocation = ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++)
                System.out.print(allocation[i][j] + " ");
            System.out.print(allocation[i][m - 1]);
        }

        System.out.print("\nMax = ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++)
                System.out.print(maximum[i][j] + " ");
            System.out.print(maximum[i][m - 1]);
        }

        System.out.print("\nNeed = ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++)
                System.out.print(need[i][j] + " ");
            System.out.print(need[i][m - 1]);
        }
        System.out.println();
    }

    private boolean isSafeState(int threadNum, int[] request) {

        System.out.print("\n Customer # " + threadNum + " requesting ");

        for (int i = 0; i < m; i++) System.out.print(request[i] + " ");
        System.out.print("Available = ");

        for (int i = 0; i < m; i++)
            System.out.print(available[i] + " ");

        for (int i = 0; i < m; i++)
            if (request[i] > available[i]) {
                System.err.println("NOT ENOUGH RESOURCES");

                return false;
            }


        boolean[] finish = new boolean[n];
        for (int i = 0; i < n; i++)
            finish[i] = false;


        int[] avail = new int[m];
        System.arraycopy(available, 0, avail, 0, available.length);


        for (int i = 0; i < m; i++) {
            avail[i] -= request[i];
            need[threadNum][i] -= request[i];
            allocation[threadNum][i] += request[i];
        }


        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (!finish[j]) {
                    boolean temp = true;

                    for (int k = 0; k < m; k++) {
                        if (need[j][k] > avail[k])
                            temp = false;
                    }

                    if (temp) {
                        finish[j] = true;
                        for (int x = 0; x < m; x++)
                            avail[x] += allocation[j][x];
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            need[threadNum][i] += request[i];
            allocation[threadNum][i] -= request[i];
        }

        boolean returnValue = true;
        for (int i = 0; i < n; i++)

            if (!finish[i]) {
                returnValue = false;
                break;
            }

        return returnValue;
    }


    @Override
    public synchronized boolean requestResources(int threadNum, int[] request) {

        if (!isSafeState(threadNum, request)) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            available[i] -= request[i];
            allocation[threadNum][i] += request[i];
            need[threadNum][i] = maximum[threadNum][i] - allocation[threadNum][i];
        }
        return true;
    }

    @Override
    public void releaseResources(int threadNum, int[] release) {

        System.out.print("\n Customer # " + threadNum + " releasing ");

        for (int i = 0; i < m; i++) System.out.print(release[i] + " ");

        for (int i = 0; i < m; i++) {
            available[i] += release[i];
            allocation[threadNum][i] -= release[i];
            need[threadNum][i] = maximum[threadNum][i] + allocation[threadNum][i];
        }
        System.out.print("Available = ");
        for (int i = 0; i < m; i++)
            System.out.print(available[i] + " ");
        System.out.print("Allocated = 5s55");
        for (int i = 0; i < m; i++)
            System.out.print(allocation[threadNum][i] + " ");
    }
}
```