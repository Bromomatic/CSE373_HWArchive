/**
 * CSE 373, Spring 2012
 * An interface that defines the operations for the Map ADT.
 */
public interface Map<K, V> {	
	/**
	 * Returns the value to which the specified key is mapped, or null if this
	 * map contains no mapping for the key.
	 */
	public V get(K key);
	
	/** 
	 * Associates the specified value with the given key in the map.  If the 
	 * key is already present in the map, the old value is replaced with the 
	 * new value. 
	 */
	public void put(K key, V value);

	/**
	 * Returns true if the map contains a mapping for the given key.
	 */
	public boolean containsKey(K key);  

	/**
	 * Prints the set in a hash table-like format.
	 */	
	public void print();

	/**
	 * Removes any existing mapping for the given key.
	 * @return the previous value associated with the key, or null if there was 
	 * 		   no mapping
	 */
	public V remove(K key);
	
	/**
	 * Returns the number of elements in this set (its cardinality)
	 */
	public int size();
} 