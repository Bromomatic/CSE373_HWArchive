Step 0:

1. 	[1,3,5,6,9,10,8,15,14,12]

2.	[15,14,8,12,9,1,5,10,3,6]

3.	[1,3,9,14,6,12,8,15,5,10]

4.	[6,9,8,12,15,10,14]

5.	[10,9,8,6,3,1,5]

6.	[6,8,9,14,15,12,10]


///-------------------------///

Step 3:

1. 	Insert should perform better on a FourHeap, as the form is better optimized for 
	minimizing operations. On inserting, with 4 children per parent, a same sized FourHeap will
	have fewer parents for a new entry to compare to as it bubbles up. For example, insertion 
	to the heap has a runtime of O(logn/log4), wheras removal has a higher runtime 
	of O(4logn/log4).
	
2.	The runtime for removals is better in the Binary Heap, as fewer comparisons are required
	to successfully bubble down. (Opposite case from FourHeap being better at insertion)
	
3. 	For the BinaryHeap:

	build: for n = 10, time = 29889.0ns

	build: for n = 100, time = 105670.0ns

	build: for n = 1000, time = 1057905.0ns
	
	
	For the FourHeap:
	
	build: for n = 10, time = 10868.0ns

	build: for n = 100, time = 101141.0ns

	build: for n = 1000, time = 1002051.0ns
	
	As we can see, FourHeap performs much better on insertions as expected.
	
	
4. 	For the BinaryHeap:

	remove: for n = 10, time = 9662.0ns

	remove: for n = 100, time = 192319.0ns

	remove: for n = 1000, time = 2964187.0ns
	
	
	For the FourHeap:
	
	remove: for n = 10, time = 15398.0ns

	remove: for n = 100, time = 283798.0ns

	remove: for n = 1000, time = 3659191.0ns
	
	As we can see, BinaryHeap performs much better on removals as expected.

 