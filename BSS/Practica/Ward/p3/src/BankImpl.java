/**
 * Created by Ward on 12-5-14.
 */
public class BankImpl implements Bank {

    private int[] available; 	// Amount of available resources
    private int[][] maximum; 	// Maximum amount for each thread
    private int[][] allocation;	// The amount currently in use by each thread
    private int[][] need;		// The remaining amount for each thread

    public BankImpl(int[] resources) {

        int m = Customer.COUNT;
        int n = 0;

        available = resources;
        maximum = new int[n][m];
        allocation = new int[n][m];
        need = new int[][];
    }

    @Override
    public void addCustomer(int threadNum, int[] maxDemand) {

        int customerNr;
        Bank theBank;

        Customer customer = new Customer(customerNr, maxDemand, theBank);
    }

    @Override
    public void getState() {

    }

    @Override
    public boolean requestResources(int threadNum, int[] request) {

        boolean finish = false;
        int[] work = available;


        return finish;
    }

    @Override
    public void releaseResources(int threadNum, int[] release) {

    }
}
