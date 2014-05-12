# BSS Practicum Week 3 Exercises

> * Andre Nanninga
> * 12-may-2014

## Chapter 7

> _1.1 There are three major methods for handling deadlock. (See Chapter 7.3.1). But actually there are four. Describe these four methods fior handling deadlock._

### Deadlock prevention

Prevent a deadlock to occur by constraining how requests for resources can be made.

### Deadlock avoidence

Requiring that the operating system is given additional information about the resources a process requests and its use during it's lifetime.

### Deadlock recovery

An algorithm to determine wether deadlock occur by examining the system state and an algorithm to recover from the deadlock.

### Deadlock ignore

Assume deadlock occur very rarely and simply ignore them. When the system is restarted the deadlocks will be resolved.

> _1.2 Consider the following snapshot of a system._

>           Allocation                Max                      Need                     Available
> |      | A | B | C | D |   | A | B | C | D |   | A | B | C | D |   | A | B | C | D |
> |------|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
> | _P0_ | 0 | 0 | 1 | 2 |   | 0 | 0 | 1 | 2 |   | 0 | 0 | 0 | 0 |   | 1 | 5 | 2 | 0 |
> | _P1_ | 1 | 0 | 0 | 0 |   | 1 | 7 | 5 | 0 |   | 0 | 7 | 5 | 0 |   |   |   |   |   |
> | _P2_ | 1 | 3 | 5 | 4 |   | 2 | 3 | 5 | 6 |   | 1 | 0 | 0 | 2 |   |   |   |   |   |
> | _P3_ | 0 | 6 | 3 | 2 |   | 0 | 6 | 5 | 2 |   | 0 | 0 | 2 | 0 |   |   |   |   |   |
> | _P4_ | 0 | 0 | 1 | 4 |   | 0 | 6 | 5 | 6 |   | 0 | 6 | 4 | 2 |   |   |   |   |   |

> Answer the following questions using the banker's algorithm:

> _a. What is the content of the matrix Need?_

See table above.

> _b. Is the system in a safe state?_

Yes, with the resources available P0 is able to run after which `1, 5, 3, 2` resources are available. With these resources P2 is able to run. After this process `3, 8, 8, 8` resources are available. P1 is able to run with these available resources after which `4, 15, 13, 8` resources are available. Next P3 can run after which `0, 21, 18, 10` resources are available. Lastly P4 is able to run.

All processes are able to run so the system is in a safe state.

> _c. If a request from process Pi arrives for (0, 4, 2, 0), can the request be granted immediately?_

Yes, the need of process Pi is `0, 4, 2, 0` and the resource available are `1, 5, 2, 0`. This means that enough resources are available for the process so it could run.

> _1.3 Java's locking mechanism (the synchronized statement) is considered reentrant. That is, if a thread acquires the lock for an object (by invoking a synchronized method or block), it can enter other synchronized methods or blocks for the same object. Explain how deadlock would be possible if Java's locking mechanism were not reentrant._

Without reentrant locking mechanisms a thread would be able to lock itself.
