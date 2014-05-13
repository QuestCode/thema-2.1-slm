# Practicum Week 3 - Yuri Hoogeweg

## Chapter 7 - Deadlocks

### 1.1: There are three major methods for handling deadlock. (See Chapter 7.3.1). But actually there are four. Describe these four methods for handling deadlock.

1. Use a protocol to prevent deadlock, **Deadlock Prevention**. This ensures that the system will never even enter a deadlocked state.
2. Allow the system to enter a deadlocked state, but develop a mechanism to detect this and recover from it.
3. Ignore deadlocks and pretend they'll never occur in the system. 
4. A combination of all of the above, selecting one of the approaches depending on the class or resource requested.

### 1.2: Consider the following snapshot of a system.
![images/snapshot1-2.png](images/snapshot1-2.png)

### Answer the following questions using the banker's algorithm:

**a. What is the content of the matrix Need?**

Need[i,j] = Max[i,j] - Allocation[i,j]. 
So starting with resource A:  
P0 = 0 - 0 = 0  
P1 = 1 - 1 = 0  
P2 = 2 - 1 = 1  
P3 = 0 - 0 = 0  
P4 = 0 = 0 = 0  

Using this method of calculation we get the following table as a result:  

**Need**

| P      | A   | B   | C   | D   |
| ------ | --- | --- | --- | --- |
| P0     | 0   | 0   | 0   | 0   |
| P1     | 0   | 7   | 5   | 0   |
| P2     | 1   | 0   | 0   | 2   |
| P3     | 0   | 0   | 2   | 0   |
| P4     | 0   | 6   | 4   | 2   |
| Total  | 1   | 13  | 11  | 4   |


**b. Is the system in a safe state?**  
A system is in a safe state if the amount of resources *needed* does not exceed the amount of resources *available*.

|                      | A   | B   | C   | D   |
| ---                  | --- | --- | --- | --- |
| **Available**        | 1   | 5   | 2   | 0   |
| **Need**             | 1   | 13  | 11  | 4   |
| **Available - Need** | 0   | -8  | -9  | -4  |

So no, the system is **NOT in a safe state**. The amount of resources needed exceeds the amount of resources available.

**c. If a request from process Pi arrives for (0, 4, 2, 0), can the request be granted immediately?**  
Yes, Pi would be safe to grant resources immediately because 0, 4, 2, 0 does not exceed the available 1, 5, 2, 0 because:

|                      | A   | B   | C   | D   |
| ---                  | --- | --- | --- | --- |
| **Need Pi**          | 0   | 4   | 2   | 0   |
| **Available**        | 1   | 5   | 2   | 0   |
| **Available - Need** | 1   | 1   | 0   | 0   |

The amount of 'needed' resources for Pi does not exceed the amount of available resources.

### 1.3: Java’s locking mechanism (the synchronized statement) is considered reentrant. That is, if a thread acquires the lock for an object (by invoking a synchronized method or block), it can enter other synchronized methods or blocks for the same object. Explain how deadlock would be possible if Java’s locking mechanism were not reentrant.  

When a lock is non-reentrant, a (synchronized/locked) method within an object cannot call another (synchronized/locked) method within that object because it waits for the lock, which it holds itself. This causes a deadlock because the object has to wait for the lock on itself, which it holds itself. Example: 

```java
class Class1{
	public synchronized void methodOne(){
		this.methodTwo();
	}

	public synchronized void methodTwo(){
	}
}
```

### 2.1: Write a multithreaded program that implements the banker's algorithm discussed in Section 7.5.3. Create n threads that request and release resources from the bank. The banker will grant the request only if it leaves the system in a safe state. You may write this program using Bibliographical Notes 271 either Pthreads or Win32 threads. It is important that access to shared data is safe from concurrent access. Such data can be safely accessed using mutex locks, which are available in both the Pthreads and Win32 API. Coverage of mutex locks in both of these libraries is described in "'producer-consumer problem" project in Chapter 6.

