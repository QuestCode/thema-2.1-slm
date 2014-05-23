##Chapter 8##

###Exercise 1.1 Page sizes###
####Why are page sizes always powers of 2?####

Because this makes the translation from logical address into a page number and page offset easy.


###Exercise 1.2 Paging###
####On a system with paging, a process cannot access memory that it does not own; why? How could the operating system allow access to other memory? Why should it or should it not?####

The addresses it requests are translated into it's own address space. Every logical address is bound by the paging hardware to some physical address.

This is a security setting that makes sure memmory of other applications cannot get corrupted.

Somtimes the OS lets programms share a page. For instance when a Word application has multiple instances. It is a loss of memory to put the executable in memmory multiple times when you can also share it.

Only reentrant code can be shared, data pages wil not be shared for obvious reasons.

###Exercise 1.3 Memory Reference###
####Consider a paging system with the page table storedin memory.####

**a) If a memory reference takes 160 nanoseconds, howlong does a paged memory reference take?**
160 + 160 = 320 nanoseconds

**b) If we add associative registers, and 75 percent of all page-table references are found in the associative registers, what is the effective memoryreference time? (Assume that finding a pagetable entry in the associative registers takes zerotime if the entry is there .)**


###Exercise 1.4 Memory Partitions###
####Given five memory partitions of 100 KB, 500 KB, 200KB, 300 KB,and 600 KB (in order ), how would each of the first-fit, best-fit, and worst-fit algorithms place processes of 312 KB, 217 KB, 112 KB, and 426 KB (in order)? Which algorithm makes the most efficient use of memory?####

| Memory in KB | First-Fit | Best-Fit  | Worst-Fit |
| ------------ | --------- | --------  | --------- |
| __100__      |           |           |           |
| __500__      | _P1_(312) | _P1_(312) | _P2_(217) |
| __200__      | _P3_(112) | _P3_(112) |           |
| __300__      | _P2_(217) | _P2_(217) |           |
| __600__      | _P4_(426) | _P4_(426) | _P3_(112) |
| Total        | 1067      | 1067      | 329       |

In this case first-fit and best-fit are the best solutions. Worst-fit cannot store the biggest processes (426 KB).


###Exercise 1.5 Page Numbers###
####Assuming a 1-KB page size, what are the page numbers and offsets for the following address reference's (provided as decimal numbers)?####

**a) 2275**

Page number = __2275 / 1024 = 2__  
Offset = __2275 % 1024 = 227__

**b) 18764**

Page number = __18764 / 1024 = 18__  
Offset = __18764 % 1024 = 332__

**c) 29000**

Page number = __29000 / 1024 = 28__  
Offset = __29000 % 1024 = 328__

**d) 254**

Page number = __254 / 1024 = 0__  
Offset = __254 % 1024 = 254__

**e) 16384**

Page number = __16384 / 1024 = 16__  
Offset = __16384 % 1024 = 0__


##Chapter 9##
###Exercise 2.1 Page Reference String####
####Consider the following page reference string:####
**1, 3, 2, 4, 2, 1, 5, 3, 2, 1, 6, 3, 7, 6, 3, 2, 1, 7, 3, 6.**
####How many page faults would occur for the following replacement algorithms, assuming four, and six frames?####
####Remember that all frames are initially empty, so your first unique pages will cost one fault each.####

##FIFO replacement##

| Frames | 1   | 3   | 2   | 4   | 2   | 1   | 5   | 3   | 2   | 1   | 6   | 3   | 7   | 6   | 3   | 2   | 1   | 7   | 3   | 6   |
| :--    | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- |
| 1      | 1   |     |     |     |     |     | 5   |     |     | 5   | 5   | 5   | 7   |     |     | 7   | 7   |     |     | 6   |
| 2      |     | 3   |     |     |     |     | 3   |     |     | 1   | 1   | 1   | 1   |     |     | 2   | 2   |     |     | 2   |
| 3      |     |     | 2   |     |     |     | 2   |     |     | 2   | 6   | 6   | 6   |     |     | 6   | 1   |     |     | 1   |
| 4      |     |     |     | 4   |     |     | 4   |     |     | 4   | 4   | 3   | 3   |     |     | 3   | 3   |     |     | 3   |
| Fault  | 1   | 1   | 1   | 1   |     |     | 1   |     |     | 1   | 1   | 1   | 1   |     |     | 1   | 1   |     |     | 1   |

**12 Faults**


| Frames | 1   | 3   | 2   | 4   | 2   | 1   | 5   | 3   | 2   | 1   | 6   | 3   | 7   | 6   | 3   | 2   | 1   | 7   | 3   | 6   |
| :--    | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- |
| 1      | 1   |     |     |     |     |     | 1   |     |     |     | 1   |     | 7   |     |     |     | 7   |     | 7   |     |
| 2      |     | 3   |     |     |     |     | 3   |     |     |     | 3   |     | 3   |     |     |     | 1   |     | 1   |     |
| 3      |     |     | 2   |     |     |     | 2   |     |     |     | 2   |     | 2   |     |     |     | 2   |     | 3   |     |
| 4      |     |     |     | 4   |     |     | 4   |     |     |     | 4   |     | 4   |     |     |     | 4   |     | 4   |     |
| 5      |     |     |     |     |     |     | 5   |     |     |     | 5   |     | 5   |     |     |     | 5   |     | 5   |     |
| 6      |     |     |     |     |     |     |     |     |     |     | 6   |     | 6   |     |     |     | 6   |     | 6   |     |
| Fault  | 1   | 1   | 1   | 1   |     |     | 1   |     |     |     | 1   |     | 1   |     |     |     | 1   |     | 1   |     |

**9 Faults**

##Optimal replacement##

| Frames | 1    | 3   | 2   | 4   | 2   | 1   | 5   | 3   | 2   | 1   | 6   | 3   | 7   | 6   | 3   | 2   | 1   | 7   | 3   | 6   |
| :--    | :--- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- |
| 1      | 1    |     |     |     |     |     | 1   |     |     |     | 1   |     | 7   |     |     |     | 7   |     |     |     |
| 2      |      | 3   |     |     |     |     | 3   |     |     |     | 3   |     | 3   |     |     |     | 3   |     |     |     |
| 3      |      |     | 2   |     |     |     | 2   |     |     |     | 2   |     | 2   |     |     |     | 1   |     |     |     |
| 4      |      |     |     | 4   |     |     | 5   |     |     |     | 6   |     | 6   |     |     |     | 6   |     |     |     |
| Fault  | 1    | 1   | 1   | 1   |     |     | 1   |     |     |     | 1   |     | 1   |     |     |     | 1   |     |     |     |

**8 Faults**

| Frames | 1   | 3   | 2   | 4   | 2   | 1   | 5   | 3   | 2   | 1   | 6   | 3   | 7   | 6   | 3   | 2   | 1   | 7   | 3   | 6   |
| :--    | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- |
| 1      | 1   |     |     |     |     |     |     |     |     |     |     |     | 1   |     |     |     |     |     |     |     |
| 2      |     | 3   |     |     |     |     |     |     |     |     |     |     | 3   |     |     |     |     |     |     |     |
| 3      |     |     | 2   |     |     |     |     |     |     |     |     |     | 2   |     |     |     |     |     |     |     |
| 4      |     |     |     | 4   |     |     |     |     |     |     |     |     | 7   |     |     |     |     |     |     |     |
| 5      |     |     |     |     |     |     | 5   |     |     |     |     |     | 5   |     |     |     |     |     |     |     |
| 6      |     |     |     |     |     |     |     |     |     |     | 6   |     | 6   |     |     |     |     |     |     |     |
| Fault  | 1   | 1   | 1   | 1   |     |     | 1   |     |     |     | 1   |     | 1   |     |     |     |     |     |     |     |

**7 Faults**

##LRU replacement##

| Frames | 1   | 3   | 2   | 4   | 2   | 1   | 5   | 3   | 2   | 1   | 6   | 3   | 7   | 6   | 3   | 2   | 1   | 7   | 3   | 6   |
| :--    | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- |
| 1      | 1   |     |     |     |     |     | 1   | 1   |     |     | 1   |     | 1   |     |     | 2   | 2   | 2   |     | 6   |
| 2      |     | 3   |     |     |     |     | 5   | 5   |     |     | 6   |     | 6   |     |     | 6   | 6   | 7   |     | 7   |
| 3      |     |     | 2   |     |     |     | 2   | 2   |     |     | 2   |     | 7   |     |     | 7   | 1   | 1   |     | 1   |
| 4      |     |     |     | 4   |     |     | 4   | 3   |     |     | 3   |     | 3   |     |     | 3   | 3   | 3   |     | 3   |
| Fault  | 1   | 1   | 1   | 1   |     |     | 1   | 1   |     |     | 1   |     | 1   |     |     | 1   | 1   | 1   |     | 1   |

**12 Faults**

| Frames | 1   | 3   | 2   | 4   | 2   | 1   | 5   | 3   | 2   | 1   | 6   | 3   | 7   | 6   | 3   | 2   | 1   | 7   | 3   | 6   |
| :--    | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- |
| 1      |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |
| 2      |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |
| 3      |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |
| 4      |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |
| 5      |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |
| 6      |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |
| Fault  |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |



###Exercise 2.2 Copy-on-write###
####What is the copy-on-write feature and under what circumstances is it beneficial t o use this feature?####
####What is the hardware support required to implement this feature ?####


###Exercise 2.3 Hit ratio of the TLB###
####Explain the term hit ratio.####

###Exercise 9.43 TLB Reach###
####Explain the term TLB reach. And explain three ways of how to increase the TLB reach.####