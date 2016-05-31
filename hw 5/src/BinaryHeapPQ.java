/**
 * CSE 373, Spring 2012
 * A generic implementation of a Priority Queue backed by a minimum
 * binary heap.
 */
import java.util.Arrays;

public class BinaryHeapPQ<T extends Comparable<T>> implements GenericPriorityQueue<T> {
	private static final int DEFAULT_CAPACITY = 10;
	protected T[] array;
	protected int size;


	@SuppressWarnings("unchecked")
	public BinaryHeapPQ() {
		array = (T[])new Comparable[DEFAULT_CAPACITY];  
		size = 0;
	}

	// Add given value to the heap, restructure heap as necessary.
	public void add(T value) {
		// grow array if needed
		if (size >= array.length - 1) {
			array = this.resize();
		}        

		// place element into heap at bottom
		size++;
		int index = size;
		array[index] = value;

		bubbleUp();
	}


	public boolean isEmpty() {
		return size == 0;
	}


	public T peek() {
		if (this.isEmpty()) {
			throw new IllegalStateException();
		}

		return array[1];
	}


	public T remove() {
		// save return value
		T result = peek();

		// get rid of the last leaf/decrement
		array[1] = array[size];
		array[size] = null;
		size--;

		bubbleDown();

		return result;
	}

	public int size() {
		return size;
	}


	public String toString() {
		return Arrays.toString(array);
	}


	protected void bubbleDown() {
		int index = 1;

		// bubble down
		while (hasLeftChild(index)) {
			// which of my children is smaller?
			int smallerChild = leftIndex(index);

			// bubble with the smaller child, if I have a smaller child
			if (hasRightChild(index) && array[leftIndex(index)].compareTo(array[rightIndex(index)]) > 0) {
				smallerChild = rightIndex(index);
			} 

			if (array[index].compareTo(array[smallerChild]) > 0) {
				swap(index, smallerChild);
			} else {
				// otherwise, get outta here!
				break;
			}

			// make sure to update loop counter/index of where last element is put
			index = smallerChild;
		}        
	}


	protected void bubbleUp() {
		int index = this.size - 1;

		while (hasParent(index) && (parent(index).compareTo(array[index]) > 0)) {
			// parent/child are out of order; swap them
			swap(index, parentIndex(index));
			index = parentIndex(index);
		}        
	}


	protected boolean hasParent(int i) {
		return i > 1;
	}


	protected int leftIndex(int i) {
		return i * 2;
	}


	protected int rightIndex(int i) {
		return i * 2 + 1;
	}


	protected boolean hasLeftChild(int i) {
		return leftIndex(i) <= size;
	}


	protected boolean hasRightChild(int i) {
		return rightIndex(i) <= size;
	}


	protected T parent(int i) {
		return array[parentIndex(i)];
	}


	protected int parentIndex(int i) {
		return i / 2;
	}


	protected T[] resize() {
		return Arrays.copyOf(array, array.length * 2);
	}


	protected void swap(int index1, int index2) {
		T tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;        
	}
}
