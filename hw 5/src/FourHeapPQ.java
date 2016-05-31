import java.util.Arrays;

// Shawn Stern - 0921475 - CSE 373, Spring 2012 - Homework 5 Step 2

public class FourHeapPQ<E extends Comparable<E>> implements GenericPriorityQueue<E> {
	private static final int DEFAULT_CAPACITY = 10;		// Initial size of heap array.
	private E[] array;									// Array to store our queue.
	private int size;									// Size of the heap (number of elements).
	
	// Constructs an empty min-FourHeap.
	@SuppressWarnings("unchecked")
	public FourHeapPQ() {
		array = (E[])new Comparable[DEFAULT_CAPACITY];  
		size = 0;
	}
	
	// Adds the given element to the heap. Elements are then sorted as necessary.
	public void add(E value) {
		// Grow array if needed.
		if (size >= array.length) {
			array = this.resize();
		}  
		
		// Place value into array, and increment size.
		// Use array[0] as the root of the heap instead of array[1].
		int index = size;
		array[index] = value;
		size++;
		
		// Resort the heap.
		bubbleUp();		
	}
	
	// Returns true if the heap is empty, false if it contains any elements.
	public boolean isEmpty() {
		return size == 0;
	}
	
	// Returns the element at the top of the heap.
	// Throws an IllegalStateException if the heap is empty.
	public E peek() {
		if (this.isEmpty()) {
			throw new IllegalStateException();
		}
		
		return array[0];
	}
	
	// Removes the element at the top of the heap and returns it. 
	// Elements are then sorted as necessary.
	public E remove() {
		// Take element out, decrement size of heap, set root to the 
		// last element in the heap, and set end value to null.
		//
		// Peek will automatically take care of the case where 
		// the user tries to remove from an empty heap.
		E removed = peek();
		size--;
		array[0] = array[size];
		array[size] = null;
		
		// Resort the heap.
		bubbleDown();
		
		return removed;
	}
	
	// Return the size of the heap.
	public int size() {
		return size;
	}
	
	// Return a string representation of the heap.
	public String toString() {
		return Arrays.toString(array);
	}
	
	// Bubble down the value to the correct location in the heap.
	protected void bubbleDown() {
		int index = 0;
		
		// Bubble down!
		while (hasChild(index, 1)) {
			// Store index of the smallest child.
			int smallerChild = childIndex(index, 1);
			
			// Bubble down with the smaller child if there is a smaller child.
			// Must check all existing children (4 max). 
			// Start with second child and work up to the fourth.
			for (int i = 2; i <= 4; i++) {
				if(hasChild(index, i) && 
						array[smallerChild].compareTo(array[childIndex(index, i)]) > 0) {
					smallerChild = childIndex(index, i);
				}
			}
			
			// Swap elements if this element is larger than one of its children.
			if (array[index].compareTo(array[smallerChild]) > 0) {
				swap(index, smallerChild);
			} else {
				// Otherwise, break out of this loop!
				break;
			}
			
			// Update loop counter/index of the element to be bubbled down.
			index = smallerChild;
		}        
	}
	
	// Bubble up the recently added element to the correct location in the heap.
	protected void bubbleUp() {
		// Index of last element is size - 1.
		int index = this.size - 1;
		
		while (hasParent(index) && (parent(index).compareTo(array[index]) > 0)) {
			// Parent/child are out of order; swap them.
			swap(index, parentIndex(index));
			index = parentIndex(index);
		}        
	}
	
	//----------Helper Methods----------//
	
	// Double the capacity of the heap array.
	private E[] resize() {
		return Arrays.copyOf(array, array.length * 2);
	}
	
	// Return if the given element has the (1 - 4)-th child.
	private boolean hasChild(int i, int whichChild) {
		// Return true if element is within bounds and contains a value other than null.
		return childIndex(i, whichChild) <= size && null != array[childIndex(i, whichChild)];
	}
	
	// Return the index of the (1 - 4)-th child of the given element.
	private int childIndex(int i, int whichChild) {
		return i * 4 + whichChild;
	}
	
	// Return if current element has a parent. (Index is 1 or higher)
	private boolean hasParent(int i) {
		return i > 0;
	}
	
	// Return the parent of the element at the given index.
	private E parent(int i) {
		return array[parentIndex(i)];
	}
	
	// Return the index of the parent of this element.
	private int parentIndex(int i) {
		return (i - 1) / 4;
	}
	
	// Swap the two given elements.
	private void swap(int index1, int index2) {
		E tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;        
	}
}