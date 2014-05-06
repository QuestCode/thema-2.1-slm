# Practicum opdrachten week 2

**1.1 Explain why the term process scheduling is actually incorrect.**

Het zijn niet processen die worden gesceduled maar threads. De term Thread scheduling kan dus ook gebruikt worden.

**1.2 Explain the difference between a CPU scheduler and a dispatcher.**

De dispatcher geeft de CPU controle nadat de CPU scheduler het process geselecteerd heeft.
De CPU scheduler selecteerd dus welk process cpu tijd krijgt maar de dispatcher geeft daadwerkelijk de controle aan het process.

**1.3 Suppose the following processes arrive for execution at the times indicated. Each process will 
run for the amount of time listed. In answering thequestions, use non-preemptive scheduling, and 
base all decisions on the information you have at the time the decision must be made.**

| Process | Arrival Time | Burst Time |
|---------|--------------|------------|
| P1 | 0.0 | 7 |
| P2 | 0.5 | 3 |
| P3 | 1.0 | 2 |

**a) ATT with FCFS
What is the average turnaround time (ATT) for theseprocesses with the Fist Come First Server 
(FCFS) scheduling algorithm?**



**b) ATT with SJF
What is the average turnaround time (ATT) for theseprocesses with the Shortest Job First (SJB) 
scheduling algorithm?**



**c) ATT with SJB and idle
The SJF algorithm is supposed to improve performance, but notice that we chose to run process P1 
at time 0 because we did not know that two shorter processes would arrive soon. Compute what the 
average turnaround time will be if the CPU is left idle for the first 1 unit and then SJF scheduling is
used. Remember that processes P1 and P2 are waitingduring this idle time, so their waiting time 
may increase. This algorithm could be known as future-knowledge scheduling.**

| P | AT | | 0 | 0.5 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | | BT | WT | TT |
|---|----|-|---|-----|---|---|---|---|---|---|---|---|---|----|----|----|----|----|-|----|----|----|
|P1 |
|P2 |
|P3 |
|PN |


**1.4 Explain the term CPU burst.**

The cpu cycles between cpu burst in which it executes a process and I/O burst in which it waits for I/O.

**1.5 Consider the following set of processes, with the length of the CPU burst given in milliseconds:**

| Process | Burst Time | Priority |
|---------|------------|----------|
| P1 | 8 | 3 |
| P2 | 1 | 1 |
| P3 | 3 | 3 |
| P4 | 1 | 4 |
| P5 | 5 | 2 |

**The process assumed to have arrived in the order P1, P2, P3, P4, P5, all at time 0.**


**a) Draw four Gantt charts that illustrate the execution of these processes using the following 
scheduling algorithms: FCFS, SJF, non-preemptive priority (a smaller priority number implies a 
higher priority) and RR (quantum = 1)**

**b) What is the turnaround time of each process for each of the scheduling algorithms in part a?**

**c) What is the waiting time of each process for each of these scheduling algorithms?**

**d) Which of the algorithms results in the minimum average waiting time (over all the processes)?**



**1.7 Which of t he following scheduling algorithms could result in starvation?**

D. Priority

Low priority processen kunnen oneindig moeten wachten wanneer er een hoge load is op een systeem.


**2.1 Consider the two general approaches to handle critical sections in operating systems. Discuss 
the favor for the preemptive approach and the difficulties with SMP architectures. (6.1)**

**2.2 Explain the differences between a counting semaphore and a binary semaphore. (6.2)**

A binary semaphore heeft maar 2 staten (0,1) en kan dus niet gebruikt worden om te tellen. Deze semaforen worden vaak gebruikt als locks.

**2.3 Describe how a program can overcome the need for busy waiting. (6.3)**