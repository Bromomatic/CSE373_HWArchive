import java.util.EmptyStackException;

// Shawn Stern - 0921475 - CSE 373, Spring 2012 - Homework 1
//
//Implementation of a DoubleStack, named LinkedStack.
// Has all standard stack features, including all your old favorites like clear(), push(), pop(),
// peek, isEmpty(), and toString().

public class LinkedStack implements DoubleStack {
	private LinkedStackNode top;
	
	// Constructs a LinkedStack object
	public LinkedStack() {
		clear();		
	}
	
	// Delete all elements in the stack
	@Override
	public void clear() {
		// Clear the stack by making the top of the stack null
		top = null;	
	}

	// Return true if the stack is empty, false otherwise
	@Override
	public boolean isEmpty() {
		// Stack is empty if the top is null
		return top == null;
	}

	// Returns the value at the top of the stack without deleting any elements
	// Throws an EmptyStackException if called when the stack contains no elements
	@Override
	public double peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		// Return the value in the top node
		return top.value;
	}

	// Returns the value at the top of the stack, and deletes that value from the stack
	// Throws an EmptyStackException if called when the stack contains no elements
	@Override
	public double pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		// Store value of the top node in a temporary double, then assign top node to the next node
		// This lets us return the value and remove that node from the stack
		double temp = top.value;
		top = top.next;
		
		return temp;
	}

	// Inserts the given double onto the top of the stack
	@Override
	public void push(double value) {
		// Use the value to create a new node, and make it point to the top of the stack
		top = new LinkedStackNode(value, top);
	}
	
	// Returns a string representation of the stack, with elements appearing in reverse order.
	public String toString() {
		// If the stack is empty, return "[]"
		if(isEmpty()) {
			return "[]";
		} else {
			// Create a new pointer to the stack so we can operate over it without modifying the
			// original linked list
			LinkedStackNode curr = top;
			
			// Begin the output string with a "["
			String out = "[";
			
			// Iterate over curr, printing elements rounded to 6 digits, followed by a ", "
			while(curr.next != null) {
				out = out + Math.round(curr.value * 1000000.0) / 1000000.0 + ", ";
				curr = curr.next;
			}
			
			// Concatenate the final element to the string and close with a "]"
			out = out + Math.round(curr.value * 1000000.0) / 1000000.0 + "]"; 
			
			return out;
		}
	}
}