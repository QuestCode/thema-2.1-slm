import java.util.*; 

public class BankImpl implements Bank {

  private int[] resources;
  private HashMap<Integer, CustomerResources> customers;

  public BankImpl(int[] resources) {
    this.resources = resources;

    customers = new HashMap<Integer, CustomerResources>();
  }

  public void addCustomer( int threadNum, int[] maxDemand ) {
    customers.put(threadNum, new CustomerResources(threadNum, maxDemand.clone()));
  }

  public synchronized boolean requestResources( int threadNum, int[] request ) {
    CustomerResources customer = customers.get(threadNum);
    boolean allowRequest = true;

    if( !isSafeState( threadNum, request ) ) {
      return false;
    }

    for(int i = 0; i < resources.length; i++) {
      if(request[i] > resources[i] || 
        request[i] > customer.max[i] || 
        request[i] > customer.max[i] - customer.allocated[i]) {
        allowRequest = false;
      }
    }

    if(allowRequest) {
      for(int i = 0; i < resources.length; i++) {
        resources[i] -= request[i];
        customer.allocated[i] += request[i];
      }

      return true;
    }

    return false;
  }

  public synchronized void releaseResources( int threadNum, int[] release ) {
    CustomerResources customer = customers.get(threadNum);

    for(int i = 0; i < resources.length; i++) {
      if(customer.allocated[i] - release[0] < 0) {
        return;
      }

      resources[i] += release[i];
      customer.allocated[i] -= release[i];      
    }
  }

  public void getState() {
    System.out.print("Resources:   ");
    System.out.println(Arrays.toString(resources));

    System.out.println("Allocated: ");
    for(CustomerResources customer : customers.values()) {
      System.out.println("Customer: " + customer.id + ", " + Arrays.toString(customer.allocated));
    }

    System.out.println("Max: ");
    for(CustomerResources customer : customers.values()) {
      System.out.println("Customer: " + customer.id + ", " + Arrays.toString(customer.max));
    }
    
    System.out.println("Need: ");
    for(CustomerResources customer : customers.values()) {
      int[] need = new int[customer.allocated.length];
      for(int i = 0; i < customer.allocated.length; i++) {
        need[i] = customer.max[i] - customer.allocated[i];
      }
      System.out.println("Customer: " + customer.id + ", " + Arrays.toString(need));
    }
  }

  private boolean isSafeState( int threadNum, int[] request ) {
    CustomerResources customer = customers.get(threadNum).clone();
    int[] resources = this.resources.clone();
    boolean[] finish = new boolean[customers.size()];
    
    for(int i = 0; i < resources.length; i++) {
      if( request[i] > resources[i] ) {
        return false;
      }
    }

    for(int i = 0; i < request.length; i++) {
      resources[i] -= request[i];
      customer.allocated[i] += request[i];
    }

    for(int i = 0; i < this.customers.size(); i++) {
      for(int j = 0; j < this.customers.size(); j++) {
        
        if( finish[j] ) {
          continue;
        }

        boolean canFinish = true;

        for(int k = 0; k < resources.length; k++) {
          if(customer.max[k] - customer.allocated[k] > resources[k]) {
            canFinish = false;
            break;
          }
        }

        if(canFinish) {
          finish[j] = true;

          for(int k = 0; k < resources.length; k++) {
            resources[k] += customer.allocated[k];
          }
        }
      }
    }

    for(int i = 0; i < customers.size(); i++) {
      if(!finish[i]) {
        return false;
      }
    }

    return true;
  }
}

class CustomerResources {

  public int id;
  public int[] allocated;
  public int[] max;
  public boolean finished;

  public CustomerResources( int id, int[] max ) {
    this.id = id;
    this.max = max;
    this.allocated = new int[max.length];
    this.finished = false;
  }

  public CustomerResources clone() {
    CustomerResources customer = new CustomerResources(id, max.clone());
    customer.allocated = allocated.clone();
    customer.finished = finished;

    return customer;
  }
  
}