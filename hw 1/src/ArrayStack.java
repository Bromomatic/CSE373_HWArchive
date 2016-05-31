import java.util.Arrays;
import java.util.EmptyStackException;

// Shawn Stern - 0921475 - CSE 373, Spring 2012 - Homework 1
//
// Implementation of a DoubleStack, named ArrayStack.
// Has all standard stack features, including all your old favorites like clear(), push(), pop(),
// peek, isEmpty(), and toString().


public class ArrayStack implements DoubleStack {
	private double[] stack;		// Array to store the stack
	private int top;			// Indicates index of the top of the stack
	
	// Constructs an ArrayStack object
	public ArrayStack() {
		clear();	
	}
	
	// Delete all elements in the current stack
	@Override
	public void clear() {
		// To clear the array, make a new one and reset the value of top
		stack = new double[10];
		top = 0;
	}

	// Returns true if the stack is empty, false otherwise
	@Override
	public boolean isEmpty() {
		// If nothing is in the stack, top is 0
		return top == 0;
	}

	// Return the value at the top of the stack without deleting it.
	// Throws an EmptyStackException if called when the stack is empty.
	@Override
	public double peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		// Return the value at the top of the stack (index is top - 1)
		return stack[top - 1];
	}

	// Returns the value at the top of the stack, and deletes it from the stack.
	// Throws an EmptyStackException if called when the stack is empty.
	@Override
	public double pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		// Decrement the value of top, since we're removing an element
		top--;		
		
		// Return stack[top] since the decrement already takes care of top - 1 case.
		return stack[top];	
	}

	// Push input double onto the top of the stack. 
	@Override
	public void push(double value) {
		// If trying to add an element beyond the scope of the array, copy the array into a new
		// array with double the current length
		if (top == stack.length) {
			stack = Arrays.copyOf(stack, stack.length * 2);
		} 
		
		// Insert value at index top, and increment top to track this change
		stack[top] = value;
		top++;
	}
	
	// Returns a string representation of the stack, with elements appearing in reverse order.
	public String toString() {
		// If the stack is empty, return "[]"
		if(isEmpty()) {
			return "[]";
		} else {
			// Begin the output string with a "["
			String out = "[";
			
			// Iterate over the array, printing elements rounded to 6 digits, followed by a ", "
			for(int i = top; i > 1; i--) {
				out = out + Math.round(stack[i - 1] * 1000000.0) / 1000000.0 + ", ";
			}
			
			// Concatenate the final element to the string and close with a "]"
			out = out + Math.round(stack[0] * 1000000.0) / 1000000.0 + "]";
			
			return out;
		}
	}
}