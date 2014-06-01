# BSS Practicum Week 4 Exercises

> Andre Nanninga  
> 26-may-2014

## Chapter 11

> _1.1 What are the advantages of the variation of linked allocation that uses a FAT to chain together the blocks of file?_

The advantage is that you can access a block in the middle of the file without going through each block from the start untill you find it in the linked list. The FAT is usually kept in memory meaning that a request for a block in the middle of a file is even faster.

## Chapter 12

> _1.2 Could a RAID Level 1 organization achieve better performance for read requests than a RAID Level 0 organization (with nonredundant striping of data)? If so, how?_

No, a RAID 0 organization must use every disk in its array for read requests and will therefor have a higher rate of reading. A RAID 1 organization will only use of one of its array for reading. The only increase in speed a RAID 1 could have is in choosing which disk to read from depending on the distance between the reader head and the block.

## Chapter  13

> _1.3 What are the advantages and disadvantages of supporting memory-mapped I/O to devicecontrol registers_

> _1.4 Describe three circumstances under which blocking I/O should be used. Describe three circumstances under which nonblocking I/O should be used. Why not just implement nonblocking I/O and have processes busy-wait until their device is ready?_

## Chapter 16

> _1.5 Explain why doubling the speed of the systems on an Ethernet segment may result in decreased network performance. What changes could help solve this problem?_

> _1.6 The original HTTP protocol used TCP/IP as the underlying network protocol. For each page, graphic, or applet a separate TCP session was constructed, used and torn down. Because of the overhead of building and destroying TCP/IP connections, performance problems resulted from this implementation method. Would using UDP rather than TCP be a good alternative? What other changes could you make to improve HTTP performance?_