public class Manager {

    public static final int MAX_RESOURCES = 5;
    private int availableResources = MAX_RESOURCES;


/**
* Decrease availableResources by count resources.
* return 0 if sufficient resources available,
* otherwise return -1
*/
            // Exclusive accessing m.b.v synchronized
    public synchronized void decreaseCount(int count) {

        // Kijk of er uberhaupt nog resources beschikbaar zijn
        // Wanneer ze niet beschikbaar zijn wacht tot ze er wel zijn
        while(availableResources < count) { 
            try {
                wait();
            }
            catch(InterruptedException e) { }
        }

            availableResources -= count;
    }

    /* Increase availableResources by count resources. */
            // Exclusive accessing m.b.v synchronized
    public synchronized void increaseCount(int count) {
        availableResources += count;

        // Laat de ander weten dat hij verder kan gaan
        notify();
    }
}