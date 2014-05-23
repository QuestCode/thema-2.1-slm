##Chapter 8##

###Exercise 1.1 Page sizes###
####Why are page sizes always powers of 2?####


###Exercise 1.2 Paging###
####On a system with paging, a process cannot access memory that it does not own; why? How could the operating system allow access to other memory? Why should it or should it not?####


###Exercise 1.3 Memory Reference###
####Consider a paging system with the page table storedin memory.####

**a) If a memory reference takes 160 nanoseconds, howlong does a paged memory reference take?**

**b) If we add associative registers, and 75 percent of all page-table references are found in the associative registers, what is the effective memoryreference time? (Assume that finding a pagetable entry in the associative registers takes zerotime if the entry is there .)**


###Exercise 1.4 Memory Partitions###
####Given five memory partitions of 100 KB, 500 KB, 200KB, 300 KB,and 600 KB (in order ), how would each of the first-fit, best-fit, and worst-fit algorithms place processes of 312 KB, 217 KB, 112 KB, and 426 KB (in order)? Which algorithm makes the most efficient use of memory?####


###Exercise 1.5 Page Numbers###
####Assuming a 1-KB page size, what are the page numbers and offsets for the following address reference's (provided as decimal numbers)?####

a) 2275

b) 18764

c) 29000

d) 254

e) 16384


##Chapter 9##
###Exercise 2.1 Page Reference String####
####Consider the following page reference string:####
**1, 3, 2, 4, 2, 1, 5, 3, 2, 1, 6, 3, 7, 6, 3, 2, 1, 7, 3, 6.**
####How many page faults would occur for the following replacement algorithms, assuming four, and six frames?####
####Remember that all frames are initially empty, so your first unique pages will cost one fault each.####

• FIFO replacement

• Optimal replacement

• LRU replacement


###Exercise 2.2 Copy-on-write###
####What is the copy-on-write feature and under what circumstances is it beneficial t o use this feature?####
####What is the hardware support required to implement this feature ?####


###Exercise 2.3 Hit ratio of the TLB###
####Explain the term hit ratio.####

###Exercise 9.43 TLB Reach###
####Explain the term TLB reach. And explain three ways of how to increase the TLB reach.####