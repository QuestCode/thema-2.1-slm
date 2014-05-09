public class Manager {
    public static final int MAX_RESOURCES = 16;
    private Integer availableResources = MAX_RESOURCES;

   /**
    * Decrease availableResources by count resources.
    * return 0 if sufficient resources available,
    * otherwise return -1
    */
 
    public int decreaseCount(int count) {
        synchronized(availableResources) {
            System.out.println("Resources available: " + availableResources);

            try {
                if(availableResources < count) {
                    availableResources.wait();
                }

                availableResources -= count;
            }
            catch(Exception e) {
                System.err.println(e.getMessage());
            }

            return 0;
        }
    }
    
    /* Increase availableResources by count resources. */
    public void increaseCount(int count) {
        synchronized(availableResources) {
            System.out.println("Increase count by " + count + " currently " + availableResources + " left");

            availableResources += count;

            try {
                availableResources.notify();
            }
            catch(Exception e) { }
        }
    }

    public static void main(String[] args) {
        Manager manager = new Manager();

        for(int i = 0; i < 5; i++) {
            Thread user = new Thread(new User(i, manager));
            user.start();
        }

        while(true) {

        }
    }
}
