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
Exponential averaging	 = `τ_n+1_ = αt_n_ + (1 - α) * _τn_`
Spinlock				 = busy waiting, no-op while loop
Dijkstra algorithm		 = graph process and resources, loops can be deadlocks
Bankers algorithm		 = determine safe state
Deadlock conditions		 = mutual exclusion, hold and wait, no preemption, circular wait
MMU						 = Memory Management Unit, relocation register
External fragmentation	 = wasted space in memory (on contigious allocation)
Internal fragmentation	 = wasted space in memory block
EAT						 = effective access time
PTBR					 = Page Table Base Register
PTLR					 = Page Table Length Register
Page sharing			 = loading read-only binaries only once
Modify (dirty) bit		 = indicate wether virtual memory is equal to value on disk


Components of computer system:

1. Hardware
2. [Virtualization layer]
3. Operating System
4. Applications
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
