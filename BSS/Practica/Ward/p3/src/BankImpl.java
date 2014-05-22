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
