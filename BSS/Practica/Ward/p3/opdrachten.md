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

