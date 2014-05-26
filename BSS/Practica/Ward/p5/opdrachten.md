###Chapter 11
####Exercise 1.1 Linked Allocation
**What are the advantages of the variation of linked allocation that uses a FAT to chain together the blocks of a file?**

The location of a block that is stored in the middle of a file can be determined by chasing the pointers stored in the FAT. Normaly you would have to access all of the individual blocks of the file.
Most of the FAT can be cached into memory so pointers can be found with memory access instead of accessing disk blocks.


###Chapter 12
####Exercise 1.2
**Could a RAID Level 1 organization achieve better performance for read requests than a RAID Level 0 organization (with nonredundant striping ofdata)? If so, how?**

Yes, Raid 1 has a better read performance. When a read is performed Raid 1 is able to decide which of the two copies of the data should be accessed for the request. The choice can depend on the access speed or the load on the drive.


###Chapter 13

####Exercise 1.3
**1.2 What are the advantages and disadvantages of supporting memory-mapped I/O to devicecontrol registers?**

Memory-mapped I/O has no need for special I/O instructions and therefore does not require the protection rules that prevent users from executing these I/O instruction.
The disadvantage is that the memory translation unit now needs to ensure that memory addresses for device control are not accessible for users.

####Exercise 1.4
**Describe three circumstances under which blocking I/O should be used. Describe three circumstances under which nonblocking I/O should beused. Why not just implement nonblocking I/O and have processes busy-wait until their deviceis ready?**

Blocking should be used when the process is waiting for only one event. (Keyboard input, Mouse input, Disk read, Touch input, etc..)  
Non-Blocking should be used when I/O may come from multiple sources and the order of arival is not pre determined. (Keyboard or mouse input, Screen or shell input, Disk or memory input)

###Chapter 16

####Exercise 1.5
**Explain why doubling the speed of the systems on an Ethernet segment may result in decreased network performance. What changes could help solve this problem?**

Because the system is then able to send more packages in a shorter time span. The network is still the same slow one and cannot handle this much traffic. There will be more collisions and therefore less througput.

####Exercise 1.6
**The original HTTP protocol used TCP/IP as the underlying network protocol. For each page, graphic, or applet, a separate TCP session was constructed, used, and torn down. Because of the overhead of building and destroying TCP/IP connections, performance problems resulted from this implementation method. Would using UDP rather than TCP be a good alternative? What other changes could you make to improve HTTP performance?**

UDP is unreliable and should not be used to send content over the network. Only when the arrival of content is not importand should you use UDP (for IP calls or Video streaming).
A better solution would be to keep the TCP connection open and reuse it for all the file transfers.