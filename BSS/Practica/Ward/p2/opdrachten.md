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


| Process | Arrival Time | Burst Time | Wait time | Total |
|---------|--------------|------------|-----------|-------|
| P1 | 0.0 | 7 | 0 | 7 |
| P2 | 0.5 | 3 | 6.5 | 9.5 |
| P3 | 1.0 | 2 | 9 | 11 |


P1 komt eerst en draait voor 7 seconden.
Tijdens het draaien komen P2 en P3 binnen.
P2 Begint te draaien op 7 seconden en heeft dan 6.5 seconde moeten wachten.
P2 draait voor 3 seconden en heeft dan totale uitvoertijd van 9.5 seconden.
P3 heeft gewacht voor 9 seconden en gaat hierna 2 seconden draaien. Een totale uitvoertijd van 11 seconden.

De gemiddelde uitvoertijd komt dan uit op 9.16 seconden.


**b) ATT with SJF
What is the average turnaround time (ATT) for theseprocesses with the Shortest Job First (SJB) 
scheduling algorithm?**

| Process | Arrival Time | Burst Time | Wait time | Total |
|---------|--------------|------------|-----------|-------|
| P1 | 0.0 | 7 | 0 | 7 |
| P2 | 0.5 | 3 | 8.5 | 11.5 |
| P3 | 1.0 | 2 | 6 | 8 |

P1 komt eerst en draait voor 7 seconden.
Tijdens het draaien komen P2 en P3 binnen.
P3 is de kortste job en mag na P1 draaien voor 2 seconden.
P2 mag als laatst en heeft dan 8.5 seconden gewacht en zal voor 3 seconden draaien.

De gemiddelde uitvoertijd komt dan uit op 8.83 seconden.


**c) ATT with SJB and idle
The SJF algorithm is supposed to improve performance, but notice that we chose to run process P1 
at time 0 because we did not know that two shorter processes would arrive soon. Compute what the 
average turnaround time will be if the CPU is left idle for the first 1 unit and then SJF scheduling is
used. Remember that processes P1 and P2 are waitingduring this idle time, so their waiting time 
may increase. This algorithm could be known as future-knowledge scheduling.**

| Process | Arrival Time | Burst Time | Wait time | Total |
|---------|--------------|------------|-----------|-------|
| P1 | 0.0 | 7 | 6 | 13 |
| P2 | 0.5 | 3 | 2.5 | 5.5 |
| P3 | 1.0 | 2 | 0 | 2 |

Als we 1 seconde wachten zijn alle processen al binnen voordat we beginnen.
P3 zal dan als eerste komen en heeft dan nog niet hoeven wachten.
Na 2 seconden zal P2 mogen beginnen en die heeft dan al 2.5 seconden moeten wachten.
P1 zal als laatste komen en die heeft dan 6 seconden moeten wachten.

De gemiddelde uitvoertijd komt dan uit op 6.83 seconden.


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

#### FCFS

| Proces / Tijd | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 |
|---------|---|---|---|---|---|---|---|---|---|----|----|----|----|----|----|----|----|----|
| P1      | ~ | ~ | ~ | ~ | ~ | ~ | ~ | ~ |   |    |    |    |    |    |    |    |    |    |
| P2      |   |   |   |   |   |   |   |   | ~ |    |    |    |    |    |    |    |    |    |
| P3      |   |   |   |   |   |   |   |   |   | ~  | ~  | ~  |    |    |    |    |    |    |
| P4      |   |   |   |   |   |   |   |   |   |    |    |    | ~  |    |    |    |    |    |
| P5      |   |   |   |   |   |   |   |   |   |    |    |    |    | ~  | ~  | ~  | ~  | ~  |


#### SJF

| Proces / Tijd | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 |
|---------|---|---|---|---|---|---|---|---|---|----|----|----|----|----|----|----|----|----|
| P2      | ~ |   |   |   |   |   |   |   |   |    |    |    |    |    |    |    |    |    |
| P4      |   | ~ |   |   |   |   |   |   |   |    |    |    |    |    |    |    |    |    |
| P3      |   |   | ~ | ~ | ~ |   |   |   |   |    |    |    |    |    |    |    |    |    |
| P5      |   |   |   |   |   | ~ | ~ | ~ | ~ | ~  |    |    |    |    |    |    |    |    |
| P1      |   |   |   |   |   |   |   |   |   |    | ~  | ~  | ~  | ~  | ~  | ~  | ~  | ~  |


#### Non-preemptive Priority

| Proces / Tijd | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 |
|---------|---|---|---|---|---|---|---|---|---|----|----|----|----|----|----|----|----|----|
| P2      | ~ |   |   |   |   |   |   |   |   |    |    |    |    |    |    |    |    |    |
| P5      |   | ~ | ~ | ~ | ~ | ~ |   |   |   |    |    |    |    |    |    |    |    |    |
| P1      |   |   |   |   |   |   | ~ | ~ | ~ | ~  | ~  | ~  | ~  | ~  |    |    |    |    |
| P3      |   |   |   |   |   |   |   |   |   |    |    |    |    |    | ~  | ~  | ~  |    |
| P4      |   |   |   |   |   |   |   |   |   |    |    |    |    |    |    |    |    | ~ |

#### Round Robin (quantum 1)

| Proces / Tijd | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 |
|---------|---|---|---|---|---|---|---|---|---|----|----|----|----|----|----|----|----|----|
| P1      | ~ |   |   |   |   | ~ |   |   | ~ |    |    | ~  |    | ~  |    | ~  | ~  | ~  |
| P2      |   | ~ |   |   |   |   |   |   |   |    |    |    |    |    |    |    |    |    |
| P3      |   |   | ~ |   |   |   | ~ |   |   | ~  |    |    |    |    |    |    |    |    |
| P4      |   |   |   | ~ |   |   |   |   |   |    |    |    |    |    |    |    |    |    |
| P5      |   |   |   |   | ~ |   |   | ~ |   |    | ~  |    | ~  |    | ~  |    |    |    |



**b) What is the turnaround time of each process for each of the scheduling algorithms in part a?**

| Proces | FCFS | SJF | Non-preemptive Priority | Round Robin |
|----|------|-----|-------------------------|-------------|
| P1 | 8    | 18  | 14                      | 18          |
| P2 | 9    | 1   | 1                       | 2           |
| P3 | 12   | 5   | 17                      | 10          |
| P4 | 13   | 2   | 18                      | 4           |
| P5 | 18   | 10  | 6                       | 15          |


**c) What is the waiting time of each process for each of these scheduling algorithms?**

| Proces | FCFS     | SJF     | Non-preemptive Priority | Round Robin |
|-------------|----------|---------|-------------------------|-------------|
| P1          | 0        | 10      | 6                       | 10          |
| P2          | 8        | 0       | 0                       | 1           |
| P3          | 9        | 2       | 14                      | 7           |
| P4          | 12       | 1       | 17                      | 3           |
| P5          | 13       | 5       | 1                       | 10          |



**d) Which of the algorithms results in the minimum average waiting time (over all the processes)?**

- FCFS 8.4
- SJF 3.6
- NPP 7.6
- RR 6.2

SJF is het snelst met een gemiddelde van 3.6.


**1.7 Which of t he following scheduling algorithms could result in starvation?**

D. Priority

Low priority processen kunnen oneindig moeten wachten wanneer er een hoge load is op een systeem.


**2.1 Consider the two general approaches to handle critical sections in operating systems. Discuss 
the favor for the preemptive approach and the difficulties with SMP architectures. (6.1)**

**2.2 Explain the differences between a counting semaphore and a binary semaphore. (6.2)**

A binary semaphore heeft maar 2 staten (0,1) en kan dus niet gebruikt worden om te tellen. Deze semaforen worden vaak gebruikt als locks.

**2.3 Describe how a program can overcome the need for busy waiting. (6.3)**
