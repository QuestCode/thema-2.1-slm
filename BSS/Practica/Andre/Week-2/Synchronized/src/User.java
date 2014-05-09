public class User implements Runnable {
  private int id;
  private Manager manager;
  private boolean hasResource;

  public User(int id, Manager manager) {
    this.id = id;
    this.manager = manager;
    this.hasResource = false;
  }

  public void run() {
    while(true) {
      if(!hasResource) {
        // Claim 1 resource
        if(manager.decreaseCount(3) == 0) {
          hasResource = true;

          System.out.println("User " + id + " got 3 resources.");
        }
        else {
          System.out.println("User " + id + " was denied 3 resources");
        }
      }
      else {
        // Release 1 resource
        manager.increaseCount(3);
        hasResource = false;
      }

      try {
        int sleep = (int) Math.floor(Math.random() * 1000);
        Thread.sleep(sleep);
      }
      catch(Exception e) {
        System.err.println("error " + e.getMessage());
      }
    }
  }
}