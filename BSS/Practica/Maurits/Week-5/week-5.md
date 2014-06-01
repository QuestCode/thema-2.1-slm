# Practicum Week 5 Exercises

### Chapter 11

##### Exercise 1.1 Linked Allocation

> What are the advantages of the variation of linked allocation that uses a FAT to chain together the blocks of a file?

1. Parts of file can be accessed directly accessed without seeking through the file blocks, because the required file block memory location can be found by looking through the pointers in the related File Allocation Table (FAT);

2. Using a FAT increases the amount of disk head seeks significantly (because for each file the disk head must move to the start of the FAT and find the block location). This is no longer the case when the FAT is stored in memory. Which also improves the random-access time;

3. Increased reliability, because (without the use of a FAT) linked allocation is vulnnerable to single block corruption, which will break the link and corrupts the entire file. Note that when the FAT is corrupted ALL the files are corrupted, which is why the OS generally keeps several backup copies of the FAT.

### Chapter 12

##### Exercise 1.2 RAID

> Could a RAID Level 1 organization achieve better performance for read requests than a RAID Level 0 organization (with nonredundant striping of data)? If so, how?

Yes, RAID level 1 achieves better read performance because of the redundant data. This means that both disk can read a part of a file simultaneously or read two files at once. Alternatively the RAID system can decide which disk serves the read request based on the location of the disk head or request load. Especially this last option is an advantage over RAID level 0, because with the latter every disk head must move to the file location in order to read the entire file (no load balancing is possible).

### Chapter 13

##### Exercise 1.3 Memory mapped I/O to devicecontrol registers

> What are the advantages and disadvantages of supporting memory-mapped I/O to device control registers?

Advantages:

1. No need for special I/O instructions;
2. No protection rules to prevent users from executing the special I/O instructions;
3. Reuse of CPU its standard data-transfer instructions to read and write the device-control registers;
4. As an example, writing millions of bytes to the graphics memory is faster than issuing millions of I/O instructions.

Disadvantages:

1. Possibility of writing to an incorrect pointer (and thus an unintended region of memory) makes the memory-mapped device register vulnernable to accidental modification;
2. If the memory is not protected properly, any user program _could_ access the device register and would therefore be a security threat.

##### Exercise 1.4 Nonblocking I/O

> Describe three circumstances under which blocking I/O should be used. Describe three circumstances under which nonblocking I/O should be used. Why not just implement nonblocking I/O and have processes busy-wait until their device is ready?

Blocking I/O should be used when a process will be waiting for one specific event. Like keyboard, mouse, touch, and disk input. It also easier for programmers to work with blocking I/O, because they don't have to overcome asynchronous paradigms.

Nonblocking I/O is useful for applications that should not sleep while waiting for an I/O operation to complete. A relevant example would be listening to incoming connections from a network socket, webserver (unpredictable requests), or a window manager that accepts mouse and keyboard input.

### Chapter 16

##### Exercise 1.5 Speed doubling on Ethernet segment

> Explain why doubling the speed of the systems on an Ethernet segment may result in decreased network performance. What changes could help solve this problem?

Systems with a higher speed have more packets traveling simultaneously over the line. This results in relatively less throughput because there are more collisions. Also some network adapter and routers might not be able to handle the high traffic speed, which may result in packet loss.

This problem can be resolved by reducing the amount of collisions. One way is to split the network into more (sub)networks, which will reduce the amount of collisions and thus increase network performance.

##### Exercise 1.6 UDP versus TCP

> The original HTTP protocol used TCP/IP as the underlying network protocol. For each page, graphic, or applet, a separate TCP session was constructed, used, and torn down. Because of the overhead of building and destroying TCP/IP connections, performance problems resulted from this implementation method. Would using UDP rather than TCP be a good alternative? What other changes could you make to improve HTTP performance?

No, UDP is not a good alternative to TCP. UDP is unreliable and therefore ideal for gaming and video streaming, but things like webpages and images must be delivered reliably (orelse they will be corrupted). A better way to reduce TCP overhead is by reusing connections, which allows the connection to stay open and be reused. This reduces the amount of constructions and tear downs, and thus the overhead is reduced.

By Maurits van Mastrigt (398497), June 1st 2014