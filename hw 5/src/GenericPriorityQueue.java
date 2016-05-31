/**
 * CSE 373, Spring 2012
 * An interface that defines the operations for a generic PriorityQueue.
 */
public interface GenericPriorityQueue<E> {
	/**
	 * Inserts the specified value into this priority queue.
	 * @param value the value to insert into the priority queue
	 */
	public void add(E value);

	/**
	 * Returns true if this priority queue contains no elements.
	 * @return true if this priority queue contains no elements; false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Retrieves, but does not remove, the value at the front of this priority queue.
	 * @return the value at the front of this priority queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public E peek();

	/**
	 * Retrieves and removes the value at the front of this priority queue.
	 * @return the value at the front of this priority queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public E remove();

	/**
	 * Returns the number of elements in this priority queue.
	 * @return the number of elements in this priority queue
	 */
	public int size();

	/**
	 * Returns a String representation of the elements in this priority queue.
	 * @return a String representation of the elements in this priority queue
	 */
	public String toString();
}