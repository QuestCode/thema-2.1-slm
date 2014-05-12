public class Customer implements Runnable {
	public static final int COUNT = 5;	// The number of threads

	private int numOfResources;			// The number of different resources
	private int[] maxDemand;			// The maximum this thread will demand
	private int customerNum;			// This customer number
	private int[] request;				// Request it is making

	private java.util.Random rand;		// Random number generator

	private Bank theBank;				// Synchronizing object

	public Customer( int customerNum, int[] maxDemand, Bank theBank ) {
		this.customerNum = customerNum;
		this.maxDemand   = new int[maxDemand.length];
		this.theBank     = theBank;

		System.arraycopy( maxDemand, 0, this.maxDemand, 0, maxDemand.length );

		numOfResources = maxDemand.length;
		request        = new int[numOfResources];
		rand           = new java.util.Random();
	}

	public void run() {
		boolean canRun = true;

		while( canRun ) {
			try {
				// Rest for awhile
				SleepUtilities.nap();

				// Make a resource request
				for( int i = 0; i < numOfResources; i++ ) {
					request[i] = rand.nextInt( maxDemand[i] + 1 );
				}

				// See if the customer can proceed
				if( theBank.requestResources( customerNum, request ) ) {
					// Use the resources
					SleepUtilities.nap();

					// Release the resources
					theBank.releaseResources( customerNum, request );
				}
			}
			catch( InterruptedException ie ) {
				canRun = false;
			}
		}

		System.out.println( "Thread # " + customerNum + " I'm interrupted." );
	}
}
