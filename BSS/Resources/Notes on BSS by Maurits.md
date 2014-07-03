# Notes on BSS by Maurits

Operating System		 = _resource allocator_ and _control program_
Kernel					 = one process running at all times
Interrupt vector		 = address list with service routines
Mode bit				 = user mode (1) or kernel mode (0)
PCB						 = Process Control Block
						 = context for CPU context switch
						 = process state, process counter, CPU registers, CPU scheduling info, memory management info, I/O status info, etc.
TLB						 = Translation Look-aside Buffer, page table cache, per process
Process					 = program in execution
Stack					 = push/pop subroutine parameters and instruction counter
Heap					 = object data
Long-term Scheduler		 = from new to ready queue (slow)
Short-term Scheduler	 = from ready to running queue (fast)
Resource sharing		 = of process: all, subset, or none
Process					 = fork(), duplicate of memory
Thread					 = clone(), shared memory
LPC						 = Local Procedure Call or "message boxing"
TCB						 = Thread Control Block (state: new, runnable, blocked, done)
Convoy effect			 = short processes before long processes (starvation)
Spinlock				 = busy waiting, no-op while loop
Dijkstra algorithm		 = graph processes and resources, loops can be deadlocks
Bankers algorithm		 = determine safe state
Deadlock conditions		 = mutual exclusion, hold and wait, no preemption, circular wait
MMU						 = Memory Management Unit, relocation register
External fragmentation	 = wasted space in memory (on contigious allocation)
Internal fragmentation	 = wasted space in memory block
DMA						 = Direct Memory Access
EAT						 = effective access time
PTBR					 = Page Table Base Register
PTLR					 = Page Table Length Register
Page sharing			 = loading read-only binaries only once
Modify (dirty) bit		 = indicate wether virtual memory is equal to value on disk
User level thread		 = green thread, thread spawned by program, mapped to kernel thread
						 = one-to-one, many-to-one, many-to-many, two-level (O:O and M:M)


Components of computer system:

1. Hardware
2. [Virtualization layer]
3. Operating System
4. System and application programs
5. Users

Address bindings:

1. Compile time (absolute code)
2. Load time (relocatable code)
3. Execution time (relocatable during runtime)

Memory allocation:

1. Contigious (one big block)

	- First-fit
	- Best-fit
	- Worst-fit

2. Paging (page table(s))
3. Segmentation (sections for each type)

Page size == frame size

Process states:

1. New
2. Ready (after admitted, interrupt, or I/O or event completion)
3. Running (after scheduler dispatch)
4. Waiting (after I/O or event wait)
5. Terminated (after exit)

Thread states:

1. New (after init)
2. Runnable (after start, I/O available, or wake up)
3. Blocked (after I/O or sleep)
4. Done (after exit of run method)

## Virtual Memory

Load from disk when required (delayed loading, lazy swapping) = page fault = expensive.

Implemented via:

1. Paging
2. Segmentation

Set modify (dirty) bit to check if loaded and value disk has not changed.

Thrashing is the event were there are so many page faults the CPU utilization is high and the degree of multiprogramming is low (because of constant swapping).

## Allocation of data blocks on disk

Types:

1. Contigious allocation (one big block)
2. Linked allocation (each block has link to next)
3. Indexed allocation (index block, 'inode')

# Other notes (since first exam)

## Bit for page load indication

Not modify (dirty) bit, but valid-invalid bit (v > in-memory, i > not-in-memory) for indicating if a page is loaded.

## RAID

RAID – multiple disk drives provides reliability via redundancy.

Raid Number:
- 0: striping, combining severel disks into 1 volume.
- 1: mirroring, keeps duplicate of each disk.
- Striped mirrors (RAID 1+0) or mirrored stripes (RAID 0+1) provides high performance and high reliability.
- Block interleaved parity (RAID 4, 5, 6) uses much less redundancy.

Redundant storage improves reliability and increase mean time between failure.

## Memory/disk segmentation

Always contigious.

## Miscellaneous

A trap is a software-generated interrupt.

Interrupts can be catched by polling or by a vectored interrupt system.

The kernel mode is entered via a trap and reset by a return from system call.

Dispatch latency is the time it takes for the dispatcher to stop one process and start another running.

Process-contention scope (PCS) is user level thread competition within the process scheduler.
System-contention scope (SCS) is competition among all threads in system.

Homogeneous processors within a multiprocessor: Same types of processors.s
Asymmetric multiprocessing: only one processor accesses the system data structures, alleviating the need for data sharing.
Symmetric multiprocessing (SMP): each processor is self-scheduling, all processes in common ready queue, or each has its own private queue of ready processes.

Solutions to critical section problem:

- Mutual Exclusion
- Progress
- Bounded Waiting

NAS is Network Attached Storage.

Disk access time has two major components:

- __Seek time__ is the time for the disk are to move the heads to the cylinder containing the desired sector
- __Rotational latency__ is the additional time waiting for the disk to rotate the desired sector to the disk head

Blocking and non-blocking I/O:

- __Blocking__ - process suspended until I/O completed
	- Easy to use and understand
	- Insufficient for some needs
- __Nonblocking__ - I/O call returns as much as available
	- User interface, data copy (buffered I/O)
	- Implemented via multi-threading
	- Returns quickly with count of bytes read or written
- __Asynchronous__ - process runs while I/O executes
	- Difficult to use
	- I/O subsystem signals process when I/O completed
