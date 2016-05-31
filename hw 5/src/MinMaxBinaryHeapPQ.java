// Shawn Stern - 0921475 - CSE 373, Spring 2012 - Homework 5 Step 1

public class MinMaxBinaryHeapPQ<T extends Comparable<T>> extends BinaryHeapPQ<T> {
	private boolean isMinHeap;	// Store if the heap is a min or max heap.
	
	// Construct a MinMaxHeapPQ. If no argument is passed, construct a max-heap.
	public MinMaxBinaryHeapPQ() {
		this(true);
	}
	
	// Construct a MinMaxBinaryHeapPQ. If isMinHeap is true, heap is constructed as a min-heap,
	// if false it constructs as a max-heap. Default is MinHeap.
	public MinMaxBinaryHeapPQ(boolean isMinHeap) {
		// Use inherited constructor, then implement the new behavior of storing the boolean.
		super();
		this.isMinHeap = isMinHeap;
	}
	
	// Bubble down the value from the top of the heap
	protected void bubbleDown() {
		// Retain default behavior if a min-heap, else do max-heap version of bubble down
		if (isMinHeap) {
			super.bubbleDown();
		} else {
			int index = 1;

			// bubble down
			while (hasLeftChild(index)) {
				// which of my children is smaller?
				int smallerChild = leftIndex(index);

				// swap ordering of comaparison to make this code work for max-heap instead
				// of min-heap!
				if (hasRightChild(index) && 
						array[leftIndex(index)].compareTo(array[rightIndex(index)]) < 0) {
					smallerChild = rightIndex(index);
				} 

				if (array[index].compareTo(array[smallerChild]) < 0) {
					swap(index, smallerChild);
				} else {
					// otherwise, get outta here!
					break;
				}

				// make sure to update loop counter/index of where last element is put
				index = smallerChild;
			}
		}
	}
	
	// Bubble up the most recently added value 
	protected void bubbleUp() {
		// Retain default behavior if a min-heap, else do max-heap version of bubble up
		if (isMinHeap) {
			super.bubbleUp();
		} else {
			int index = this.size;

			// Change order of compareTo function to make the bubble up correct for max-heap
			while (hasParent(index) && (parent(index).compareTo(array[index]) < 0)) {
				// parent/child are out of order; swap them
				swap(index, parentIndex(index));
				index = parentIndex(index);
			} 
		}	
	}
}