/**
 * CSE 373, Spring 2012
 * This program tests the GenericPriorityQueue implementations.
 * YOU SHOULD ADD YOUR TESTS TO THIS FILE.
 */

import java.util.Random;

public class HW5PriorityQueueTest {
	public static void main(String[] args) {
		testMinMaxBinaryHeap(true);
		System.out.println();
		System.out.println("///-------------------------------------------------------///");
		System.out.println();

		testMinMaxBinaryHeap(false);
		System.out.println();
		System.out.println("///-------------------------------------------------------///");
		System.out.println();
		
		testFourHeap();
		System.out.println();
		System.out.println("///-------------------------------------------------------///");
		System.out.println();
		
		timeTestFourHeap(10);
		timeTestFourHeap(100);
		timeTestFourHeap(1000);
		System.out.println();
		System.out.println("///-------------------------------------------------------///");
		System.out.println();
		
		timeTestBinaryHeap(10);
		timeTestBinaryHeap(100);
		timeTestBinaryHeap(1000);
	}   

	/**
	 * A very minimal test for the MinMaxBinaryHeap.
	 * @param isMin
	 */
	public static void testMinMaxBinaryHeap(boolean isMin) {
		GenericPriorityQueue<Integer> minInts = new MinMaxBinaryHeapPQ<Integer>(isMin);

		minInts.add(13);
		minInts.add(20);
		minInts.add(11);
		minInts.add(44);
		minInts.add(3);
		minInts.add(7);
		minInts.add(9);

		System.out.println(minInts);
		System.out.println(minInts.peek());
		System.out.println();

		while (!minInts.isEmpty()) {
			System.out.println(minInts.remove());               
			System.out.println(minInts);
		}

		System.out.println();
		System.out.println();

		GenericPriorityQueue<String> minStrs = new MinMaxBinaryHeapPQ<String>(isMin);
		minStrs.add("Kona");
		minStrs.add("Daisy");        
		minStrs.add("Meghan");
		minStrs.add("Martin");
		System.out.println(minStrs);
		

		while (!minStrs.isEmpty()) {
			System.out.println(minStrs.remove());
			System.out.println(minStrs);
		}

		System.out.println();
	}


	/**
	 * Builds a binary heap of the given size with random integers.  
	 * This method could be used to time your binary heap inserts.
	 * @param size
	 * @return
	 */
	private static GenericPriorityQueue<Integer> buildBinaryHeap(int size) {
		Random rand = new Random();
		GenericPriorityQueue<Integer> bh = new BinaryHeapPQ<Integer>();

		for (int i = 0; i < size; i++) {
			bh.add(rand.nextInt(2 * size) - size / 2);
		}

		return bh;
	}    

	/**
	 * Builds a four heap of the given size with random integers.  
	 * This method could be used to time your four-heap inserts.
	 * @param size
	 * @return
	 */    
	private static GenericPriorityQueue<Integer> buildFourHeap(int size) {
		Random rand = new Random();
		GenericPriorityQueue<Integer> fh = new FourHeapPQ<Integer>();

		for (int i = 0; i < size; i++) {
			fh.add(rand.nextInt(2 * size) - size / 2);
		}

		return fh;
	}

	/**
	 * Empties a priority queue through a series of removes.  
	 * This method could be used to time your binary and four-heap removes.
	 * @param size
	 * @return
	 */        
	private static void emptyHeap(GenericPriorityQueue<Integer> pq) {
		while (!pq.isEmpty()) {
			pq.remove();
		}    	
	}
	
	// Test behavior of the FourHeap's methods
	public static void testFourHeap() {
		// Fill a four heap with random values, check to make sure that the elements removed 
		// come out in the correct order of smallest to largest (proper queue behavior)
		GenericPriorityQueue<Integer> a = buildFourHeap(30);
		System.out.println(a);
		
		for (int i = 0; i <= 20; i++) {
			// Check removes AND sizeOf
			System.out.println(a.remove() + "\t size of the heap is now: " + a.size());
		}
		
		// Check that array looks correct, and that peek shows top value
		System.out.println(a);
		System.out.println(a.peek());
		
		System.out.println();
		
		// Check if heap empties completely, correctly
		emptyHeap(a);
		System.out.println(a);
		System.out.println("Size of the array is now: " + a.size());
		System.out.println();
		
		// Should return true in this case
		System.out.println(a.isEmpty());
		
		System.out.println();
		
		// Adding an element should now make it false
		a.add(5);
		System.out.println(a.isEmpty());
		
		System.out.println();
		
		// Check and verify that calling remove (and thus peek) on an empty FourHeap throws the exception
		// Commented out so code doesn't break because of the exception, uncomment to see pretty red letters
		emptyHeap(a);
		/*
		a.remove();
		a.peek();
		*/
	}
	
	
	public static void timeTestFourHeap(int n) {
		// Find runtime to build the heap
		double sum = 0;
		long startTime = System.nanoTime();
		GenericPriorityQueue<Integer> a = buildFourHeap(n);
		sum = System.nanoTime() - startTime;

		// report and return results
		System.out.println("build: for n = " + n + ", time = " + sum + "ns");
		System.out.println();
		
		double sum2 = 0;
		long startTime2 = System.nanoTime();
		emptyHeap(a);
		sum2 = System.nanoTime() - startTime2;

		// report and return results
		System.out.println("remove: for n = " + n + ", time = " + sum2 + "ns");
		System.out.println();
	}
	
	public static void timeTestBinaryHeap(int n) {
		// Find runtime to build the heap
		double sum = 0;
		long startTime = System.nanoTime();
		GenericPriorityQueue<Integer> a = buildBinaryHeap(n);
		sum = System.nanoTime() - startTime;

		// report and return results
		System.out.println("build: for n = " + n + ", time = " + sum + "ns");
		System.out.println();
		
		double sum2 = 0;
		long startTime2 = System.nanoTime();
		emptyHeap(a);
		sum2 = System.nanoTime() - startTime2;

		// report and return results
		System.out.println("remove: for n = " + n + ", time = " + sum2 + "ns");
		System.out.println();
	}
}




