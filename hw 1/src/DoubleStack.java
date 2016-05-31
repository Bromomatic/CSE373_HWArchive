/**
 * Interface for a stack of primitive doubles.
 * @author Jessica Miller
 */
public interface DoubleStack {
    /**
     * Empties the stack of all elements.
     */
    public void clear();
	
    /** 
     * Tests if the stack is empty.
     */
    public boolean isEmpty();

    /**
     * Returns the next double value to be popped.
     * @throws EmptyStackException if stack is empty
     */
    public double peek();    
    
    /**
     * Pops a double value off the top of the stack.
     * @return the popped value
     * @throws EmptyStackException if stack is empty
     */
    public double pop();    
    
    /**
     * Pushes a double value onto the top of the stack.
     */
    public void push(double value);

    /**
     * Returns a String representation of the stack.
     * @return a String representation of the stack
     */
    public String toString();
}
