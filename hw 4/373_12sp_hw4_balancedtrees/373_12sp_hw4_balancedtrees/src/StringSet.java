/**
 * CSE 373, Spring 2012
 * An interface that defines the operations for a Set ADT for Strings.
 */
public interface StringSet {
    /** 
     * Adds the specified String to the Set if it is not already present.
     * @param value value to be added to the set
     * @return true if this set did not already contain the String 
     */
    public boolean add(String value);

    /**
     * Searches the Set for the specified String.
     * @param value value whose presence in this set is to be tested
     * @return true if the Set contains the String; false otherwise
     */
    public boolean contains(String value);
    
    /**
     * Prints the set in a tree-like format.
     */
    public void print();

    /**
     * Removes the specified String from this set if it is present.
     * @param value value to be removed from this set, if present
     * @return true if this set contained the specified value; false otherwise
     */
    public boolean remove(String value);
    
    /**
     * Returns the number of elements in this set (its cardinality).
     * @return the number of elements in this set (its cardinality)
     */
    public int size();
}