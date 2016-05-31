/**
 * CSE 373, Spring 2012
 * The HashMapEntry represents a single entry in a HashMap.
 */
public class HashMapEntry<K, V> {
	public K key;
	public V value;
	public HashMapEntry<K, V> next;

	// Constructs a single hash entry.
	public HashMapEntry(K key, V value) {
		this(key, value, null);
	}

	// Constructs a single hash entry, with reference to the next hash entry.
	public HashMapEntry(K key, V value, HashMapEntry<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}    
}
