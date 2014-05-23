# BSS Practicum Week 3 Exercises

> Andre Nanninga  
> 23-may-2014  

## Chapter 8

> _1.1 Why are page sizes always powers of 2?_

The translation between pages and frames is done by taking the head of a memory address and replacing it with a frame address.

With a page size of 128 bytes the every bit beyond 7 bits is considered the head. So the address `11010 1001` can simply be translated by taking the head: `11` and finding the matching frame to this page number, for example `01`. The resulting physical address would then be `01010 1001`. 

When a page size is not a power of 2 this would not be possible.

> _1.3 Consider a paging system with the page table stored in memory._
> _a. If a memory reference takes 160 nanoseconds, how long does a paged memory reference take?_

320 nanoseconds. We must first access memory for the page table and frame number (160 nanoseconds) and then access the desired byte in memory (160 nanoseconds).

> _b. If we add associative registers, and 75 percent of all page-table references are found in the associative registers, what is the effective memory reference time? (Assume that finding a pagetable entry in the associative registers takes zero time if the entry is here.)_

The access time when a reference is found is 160 nanoseconds, 0 nanoseconds to find the entry in the TLB and 160 nanoseconds to access the memory. The access time when no reference is found is 320 nanoseconds as explained above. 