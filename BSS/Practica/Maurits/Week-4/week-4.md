# Practicum Week 4 Exercises

### Chapter 8

##### Exercise 1.1 Page sizes

Using a power of two as a page size makes the translation of a logical address into a page number and offset suprisingly easy, because the high order bits (m - n) can be used as page number and the rest (n) as page offset. This saves complex translation, which makes mapping logical to physical addresses a lot faster.

##### Exercise 1.2 Paging

Allowing processes to access memory of other processes compromises the security of the system, because in that case processes no longer control which data is presented to the 'outside world' (other processes).

The operating system can allow access to other memory by making an overlap in the page table. Which would make the logical address of both processes resolve to the same physical address, thus allowing both processes to access the same data. For non read-only memory this is dangerous, because there is no mutual exclusion and deadlocks may occur. This should be handled carefully. For example in case of read-only binaries, to prevent it from being loaded into memory twice.

##### Exercise 1.3 Memory Reference

a) Twice the time (320 nanoseconds), because first the page table must be accessed to translate the logical address to a physical one. The page table itself is also in memory, so it takes the same time as normal memory access.

b) In 75% of the cases the memory access is done once (only for the actual memory data) and in 25% (the rest) of the cases a page table lookup is required (which requires one additional memory access). This means the effective memory reference time is 200 nanoseconds: `0.75 * 160 + 0.25 * 320 = 120 + 80 = 200`.

##### Exercise 1.4 Memory Partitions

|               | Partition | First-fit | Best-fit  | Worst-fit |
| :--------     | :-------- | :-------- | :-------- | :-------- |
|               | 100       |           |           |           |
|               | 500       | 312       | 312       | 217       |
|               | 200       | 112       | 112       |           |
|               | 300       | 217       | 217       |           |
|               | 600       | 426       | 426       | 112       |
| &nbsp;        |           |           |           |           |
| Total         | 1700      | 1067      | 1067      | 329       |
| __Remaining__ |           | __633__   | __633__   | __1371__  |

In this case both first-fit and best-fit are the best as they are equally efficient.

##### Exercise 1.5 Page Numbers

| Logical address | Page number | Page offset |
| :--------       | :--------   | :--------   |
| 2275            | 2           | 227         |
| 18764           | 18          | 332         |
| 29000           | 28          | 328         |
| 254             | 0           | 254         |
| 16384           | 16          | 0           |

Formula: `logical address / page size = page number REST page offset`.

### Chapter 9

##### Exercise 2.1 Page Reference String

F = Frame, TF = Total number of faults.

__First In First Out__

| F      | 1  | 3  | 2  | 4  | 2  | 1  | 5  | 3  | 2  | 1  | 6  | 3  | 7  | 6  | 3  | 2  | 1  | 7  | 3  | 6  | TF     |
| :----- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :-     |
| 1      | 1  |    |    |    |    |    | 5  |    |    | 5  | 5  | 5  | 7  |    |    | 7  | 7  |    |    | 7  |        |
| 2      |    | 3  |    |    |    |    | 3  |    |    | 1  | 1  | 1  | 1  |    |    | 2  | 2  |    |    | 2  |        |
| 3      |    |    | 2  |    |    |    | 2  |    |    | 2  | 6  | 6  | 6  |    |    | 6  | 1  |    |    | 1  |        |
| 4      |    |    |    | 4  |    |    | 4  |    |    | 4  | 4  | 3  | 3  |    |    | 3  | 3  |    |    | 6  |        |
| Fault  | 1  | 1  | 1  | 1  |    |    | 1  |    |    | 1  | 1  | 1  | 1  |    |    | 1  | 1  |    |    | 1  | __12__ |

| F      | 1  | 3  | 2  | 4  | 2  | 1  | 5  | 3  | 2  | 1  | 6  | 3  | 7  | 6  | 3  | 2  | 1  | 7  | 3  | 6  | TF    |
| :----- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :-    |
| 1      | 1  |    |    |    |    |    |    |    |    |    |    |    | 7  |    |    |    | 7  |    | 7  |    |       |
| 2      |    | 3  |    |    |    |    |    |    |    |    |    |    | 3  |    |    |    | 1  |    | 1  |    |       |
| 3      |    |    | 2  |    |    |    |    |    |    |    |    |    | 2  |    |    |    | 2  |    | 3  |    |       |
| 4      |    |    |    | 4  |    |    |    |    |    |    |    |    | 4  |    |    |    | 4  |    | 4  |    |       |
| 5      |    |    |    |    |    |    | 5  |    |    |    |    |    | 5  |    |    |    | 5  |    | 5  |    |       |
| 6      |    |    |    |    |    |    |    |    |    |    | 6  |    | 6  |    |    |    | 6  |    | 6  |    |       |
| Fault  | 1  | 1  | 1  | 1  |    |    | 1  |    |    |    | 1  |    | 1  |    |    |    | 1  |    | 1  |    | __9__ |

__Optimal Replacement__

| F      | 1  | 3  | 2  | 4  | 2  | 1  | 5  | 3  | 2  | 1  | 6  | 3  | 7  | 6  | 3  | 2  | 1  | 7  | 3  | 6  | TF    |
| :----- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :-    |
| 1      | 1  |    |    |    |    |    | 1  |    |    |    | 1  |    | 7  |    |    |    | 7  |    |    |    |       |
| 2      |    | 3  |    |    |    |    | 3  |    |    |    | 3  |    | 3  |    |    |    | 3  |    |    |    |       |
| 3      |    |    | 2  |    |    |    | 2  |    |    |    | 2  |    | 2  |    |    |    | 1  |    |    |    |       |
| 4      |    |    |    | 4  |    |    | 5  |    |    |    | 6  |    | 6  |    |    |    | 6  |    |    |    |       |
| Fault  | 1  | 1  | 1  | 1  |    |    | 1  |    |    |    | 1  |    | 1  |    |    |    | 1  |    |    |    | __8__ |

| F      | 1  | 3  | 2  | 4  | 2  | 1  | 5  | 3  | 2  | 1  | 6  | 3  | 7  | 6  | 3  | 2  | 1  | 7  | 3  | 6  | TF    |
| :----- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :-    |
| 1      | 1  |    |    |    |    |    |    |    |    |    |    |    | 1  |    |    |    |    |    |    |    |       |
| 2      |    | 3  |    |    |    |    |    |    |    |    |    |    | 3  |    |    |    |    |    |    |    |       |
| 3      |    |    | 2  |    |    |    |    |    |    |    |    |    | 2  |    |    |    |    |    |    |    |       |
| 4      |    |    |    | 4  |    |    |    |    |    |    |    |    | 7  |    |    |    |    |    |    |    |       |
| 5      |    |    |    |    |    |    | 5  |    |    |    |    |    | 5  |    |    |    |    |    |    |    |       |
| 6      |    |    |    |    |    |    |    |    |    |    | 6  |    | 6  |    |    |    |    |    |    |    |       |
| Fault  | 1  | 1  | 1  | 1  |    |    | 1  |    |    |    | 1  |    | 1  |    |    |    |    |    |    |    | __7__ |

__Least Recently Used__

| F      | 1  | 3  | 2  | 4  | 2  | 1  | 5  | 3  | 2  | 1  | 6  | 3  | 7  | 6  | 3  | 2  | 1  | 7  | 3  | 6  | TF     |
| :----- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :-     |
| 1      | 1  |    |    |    |    |    | 1  | 1  |    |    | 1  |    | 1  |    |    | 2  | 2  | 2  |    | 6  |        |
| 2      |    | 3  |    |    |    |    | 5  | 5  |    |    | 6  |    | 6  |    |    | 6  | 6  | 7  |    | 7  |        |
| 3      |    |    | 2  |    |    |    | 2  | 2  |    |    | 2  |    | 7  |    |    | 7  | 1  | 1  |    | 1  |        |
| 4      |    |    |    | 4  |    |    | 4  | 3  |    |    | 3  |    | 3  |    |    | 3  | 3  | 3  |    | 3  |        |
| Fault  | 1  | 1  | 1  | 1  |    |    | 1  | 1  |    |    | 1  |    | 1  |    |    | 1  | 1  | 1  |    | 1  | __12__ |

| F      | 1  | 3  | 2  | 4  | 2  | 1  | 5  | 3  | 2  | 1  | 6  | 3  | 7  | 6  | 3  | 2  | 1  | 7  | 3  | 6  | TF    |
| :----- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :- | :-    |
| 1      | 1  |    |    |    |    |    |    |    |    |    |    |    | 1  |    |    |    |    |    |    |    |       |
| 2      |    | 3  |    |    |    |    |    |    |    |    |    |    | 3  |    |    |    |    |    |    |    |       |
| 3      |    |    | 2  |    |    |    |    |    |    |    |    |    | 2  |    |    |    |    |    |    |    |       |
| 4      |    |    |    | 4  |    |    |    |    |    |    |    |    | 7  |    |    |    |    |    |    |    |       |
| 5      |    |    |    |    |    |    | 5  |    |    |    |    |    | 5  |    |    |    |    |    |    |    |       |
| 6      |    |    |    |    |    |    |    |    |    |    | 6  |    | 6  |    |    |    |    |    |    |    |       |
| Fault  | 1  | 1  | 1  | 1  |    |    | 1  |    |    |    | 1  |    | 1  |    |    |    |    |    |    |    | __7__ |

##### Exercise 2.2 Copy-on-write

The copy-on-write feature allows pages to be shared among processes until either one of them tries to alter the value. When this happens, a copy of the page will be created (because the page is marked as 'copy-on-write'), the copy will be allocated as replacement for the original page, and the new value will be writed to the copied page instead.

This mechanism is useful for processes that are accessing the same set of data. For example a binary executable (which is read-only). Also it initially speeds up creating forks of processes, because the pages are shared and will only later be copied (if necessary).

Copy-on-write provides write protection, because the original can not be overwritten which ensures the processes that share the page will not interfere with each other. This protection is provided by a hardware mechanism that will execute a trap when a write protected page is tried to be overwritten. The trap will then copy and reallocate the page, as explained earlier.

##### Exercise 2.3 Hit ratio of the TLB

The hit ratio of the translation look-aside buffer (TLB) is the percentage of times that a particular page number is found in the buffer. The higher the hit ratio, the better. With a hit ratio of 80%, four out of five times the translation of logical to physical address is cached and no extra memory access to the page table is required.

The hit ratio can be increased by expanding the number of entries in the TLB. The downside of this is that the associative memory used to construct the TLB is both expensive and power hungry.

##### Exercise 9.43 TLB Reach

The TLB reach is related to the TLB hit ratio. It refers to the amount of memory accessible from the TLB, in other words the number of entries multiplied by the page size. The three ways of expanding the TLB reach are:

1. By doubling the number of entries in the TLB, the reach is also doubled. Unfortunately this may still provide insufficient storing size for the working set.

2. By increasing the size of the page, which multiplies the reach in an equal fashion. The dowside of using a large page size is, however, that this may lead to increased fragmentation.

3. By use of different page sizes. Which will be provided by the operating system, instead of hardware. Which will reduce performance. Also each TLB entry must have an extra field to indicate the size of the page frame.

By Maurits van Mastrigt (398497), May 23th 2014