import java.lang.InterruptedException;

public class Manager {

	public static final int MAX_RESOURCES = 5;

	private Integer availableResources = MAX_RESOURCES;

	/**
	 * Decrease availableResources by count resources.
	 * return 0 if sufficient resources available,
	 * otherwise block until resource becomes available.
	 */
	public int decreaseCount( int count ) throws InterruptedException {
		synchronized( availableResources ) {
			if( availableResources < count ) {
				availableResources.wait();
			}

			availableResources -= count;
			return 0;
		}
	}

	/* Increase availableResources by count resources. */
	public void increaseCount( int count ) throws InterruptedException {
		synchronized( availableResources ) {
			availableResources += count;

			availableResources.notify();
		}
	}
}
