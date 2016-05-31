/**
 * CSE 373, Spring 2012
 * This is a generic hash map implementation of the Map ADT.
 */
public class HashMap<K, V> implements Map<K, V> {
	private static final int DEFAULT_SIZE = 11;
	private HashMapEntry<K, V>[] table;
	private int size;

	public HashMap() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public HashMap(int tableSize) {
		table = new HashMapEntry[tableSize];
		size = 0;
	}

	/**
	 * Returns the value to which the specified key is mapped, or null if this
	 * map contains no mapping for the key.
	 */
	public V get(K key) {
		// This code seems redundant since the 'V  value = null' line will
		// technically return null if the value isn't contained. I imagine it 
		// could improve runtime by skipping this extra check and just using
		// the contains code in the case where the key isn't contained.
		if (!containsKey(key)) {
			return null;
		}
		
		// Create a temporary value. If we got to this point we know the map
		// contains the key.
		V value = null;
		int keyBucket = hash(key);

		// Iterate and find the value in the map, then set the value to our temp.
		HashMapEntry<K, V> temp = table[keyBucket];
		while (temp != null) {
			if ((temp.key == null && key == null) 
					|| (temp.key != null && temp.key.equals(key))) {
				// If found, set value to the found value.
				value = temp.value;
			}
			temp = temp.next;
		}
		
		// Return the value. If found, it will have a non-null value,
		// else it will return null.
		return value;
	}

	/** 
	 * Associates the specified value with the given key in the map.  If the 
	 * key is already present in the map, the old value is replaced with the 
	 * new value. 
	 */
	public void put(K key, V value) {
		int keyBucket = hash(key);

		HashMapEntry<K, V> temp = table[keyBucket];
		while (temp != null) {
			if ((temp.key == null && key == null) 
					|| (temp.key != null && temp.key.equals(key))) {
				temp.value = value;
				return;
			}
			temp = temp.next;
		}

		table[keyBucket] = new HashMapEntry<K, V>(key, value, table[keyBucket]);
		size++;
	}


	/**
	 * Returns true if the map contains a mapping for the given key.
	 */
	public boolean containsKey(K key) {
		int keyBucket = hash(key);

		HashMapEntry<K, V> temp = table[keyBucket];
		while (temp != null) {
			if ((temp.key == null && key == null) 
					|| (temp.key != null && temp.key.equals(key))) {
				return true;
			}
			temp = temp.next;
		}

		return false;
	}


	/**
	 * Prints the set in a hash table-like format.
	 */
	public void print() {
		for (int i = 0; i < table.length; i++) {
			System.out.printf("%d: ", i);

			HashMapEntry<K, V> temp = table[i];
			while (temp != null) {
				System.out.print("(" + temp.key + ", " + temp.value + ")");

				if (temp.next != null) {
					System.out.print(" --> ");
				}
				temp = temp.next;
			}

			System.out.println();
		}
	}


	/**
	 * Removes any existing mapping for the given key.
	 * @return the previous value associated with the key, or null if there was 
	 * 		   no mapping
	 */
	public V remove(K key) {
		// Return null immediately if value not contained
		if (!containsKey(key)) {
			return null;
		}
		
		// Store the value before deleting it from the map.
		V value = get(key);
		
		// Make a temp node to iterate over the linked list.
		int keyBucket = hash(key);
		HashMapEntry<K, V> curr = table[keyBucket];
		
		// Special case when root node is equal to the value.
		if ((curr.key == null && key == null) 
				|| (curr.key != null && curr.key.equals(key))) {
			// Remove node and return the value immediately.
			// No sense in wasting resources doing extra iterations if
			// we've already found and removed the mapping.
			table[keyBucket] = table[keyBucket].next;
			return value;
		}
		
		// Generic case, look at next node and see if it matches. In this case, 
		// make the list skip over that node to 'delete' it. Works for end nodes.
		while (curr.next != null) {
			if ((curr.next.key == null && key == null) 
					|| (curr.next.key != null && curr.next.key.equals(key))) {
				// Remove next node by skipping over it, and return the value
				// immediately, skipping any further iterations.
				curr.next = curr.next.next;
				return value;
			}
			curr = curr.next;
		}
		
		// Return the value if not found by this point (return null). 
		// Makes the compiler happy.
		return value;
	}


	/**
	 * Returns the number of elements in this set (its cardinality)
	 */
	public int size() {
		return size;
	}


	private int hash(K key) {
		if (key == null) {
			return 0;
		} else {
			return Math.abs(key.hashCode() % this.table.length);
		}
	}
}
