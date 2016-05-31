1. Since I'm unfamiliar with JUnit, I went ahead and wrote a testing class with a number of
scenarios to make sure the stacks work properly. It mainly invovled a series of pushes, pops,
clears, and toString calls, in addition to using isEmpty() as a boolean to keep from hitting
exceptions.

I tested for these main cases: each stack starts empty, pushing properly puts elements into the 
structure like a stack, toString does not modify the original stack strcture, clear actually
removes everything from the stack, peek returns the value without modifying the stack, the
ArrayStack properly resizes if we attempt to put more than 10 elements into it, exceptions are
thrown when needed, pop returns the value AND removes it from the stack, toString properly formats
the string with commas and spaces in the right places, and isEmpty works correctly.

---

2. The secret phrase is from The Wizard of Oz, and is Dorothy saying "Toto, I don't think we're
in Kansas anymore."  Am I a nerd for recognizing the phrase when I first heard it reversed? :D

---

3. I can imagine doing this using a pair of queues:

// fields
private queue = new queue

// Put element into the 'stack'
public void push(double value) {
	enqueue value into queue
}

// pop an element from the stack
public double pop() {
	// Dequeue an element from the queue and immediately enqueue it into the same queue until the 
	// element at the front of the queue is the most recently pushed value, takes (n-1) dequeues 
	// to get to that element, where n is the size of the queue
	
	int size = size of the queue //(# elements in the queue)
	
	for size - 1 operations {
		dequeue element, save as a double
		immediately re-enqueue the double into the queue
	}
	
	return dequeue; // dequeues element at front of queue and returns it			
}

---
	
4. Looking at the Queue inmplementation vs the Array implementation, there are some marked 
inefficiencies in the queue version. While queue's push is very simple since it doesn't bother 
with the resizing case the array has to, the pop algorithm is wildy different and slow.

The pop operation in the Array stack runs in constant time, regardless of how large the stack is.  
The pop function in the queue version runs in O(n) time because it has to shift n-1 elements (n =
size of queue at the beginning of the call) out of one queue and back in, then return the value,
and finally remove it.

I would always choose the Array over the Queue in this case. Except for the resizing, the array 
runs faster at O(1), and the code is less of a headache to think about.
