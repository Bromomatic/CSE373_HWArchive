// Shawn Stern - 0921475 - CSE 373, Spring 2012 - Homework 2 #5

import java.util.Arrays; 	// For testing only
import java.util.Random; 	// For testing only

public class FirstNonSmaller {
	
	public static final int INT = 6;			// Global int for firstNonSmaller to look for
	public static final int NUM = 10;			// Global int used for testing
	public static final int NUM_SAMPLES = 10;	// Global int for how many times to run test loop
	
	public static void main(String[] args) {
		// Commented code was used to test that method actually finds the right index
		
//		int[] a = createRandomSortedArray(20);
//		int[] b = createRandomSortedArray(20);
//		int[] c = createRandomSortedArray(20);
//		int[] d = createRandomSortedArray(20);
//		int[] e = createRandomSortedArray(20);
//		
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
//		System.out.println(Arrays.toString(c));
//		System.out.println(Arrays.toString(d));
//		System.out.println(Arrays.toString(e));
//		
//		System.out.println();
//		
//		System.out.println("Smallest index of " + INT + " is: " + firstNonSmallerIndex(a, INT));
//		System.out.println("Smallest index of " + INT + " is: " + firstNonSmallerIndex(b, INT));
//		System.out.println("Smallest index of " + INT + " is: " + firstNonSmallerIndex(c, INT));
//		System.out.println("Smallest index of " + INT + " is: " + firstNonSmallerIndex(d, INT));
//		System.out.println("Smallest index of " + INT + " is: " + firstNonSmallerIndex(e, INT));
		
		// run the timed tests, don't do anything with the double
		test(NUM);
		test(10 * NUM);
		test(100 * NUM);
		test(1000 * NUM);
		test(10000 * NUM);	
		test(100000 * NUM);
	}
	
	// Accepts a sorted array of integers and an integer value. Returns the smallest index that
	// a number of the given value can be found in the given array. Returns -1 if the value
	// does not exist in the array.
	public static int firstNonSmallerIndex(int[] array, int value) {
		return firstNonSmallerIndex(array, value, 0, array.length - 1);		
	}

	// Helper method for firstNonSmallerIndex
	private static int firstNonSmallerIndex(int[] nums, int value, int min, int max) {
		// In this case, value not found in array
		if (min > max) {
			return -1;
		}

		// Find the midpoint of the array based on min and max
		int mid = (min + max) / 2;
		
		// If we're on the desired value and the element in front of us is less than value (or 0
		// which means we're at the beginning of the array anyway) return the current value of mid
		if (nums[mid] == value && (mid == 0 || nums[mid - 1] < value)) {
			return mid;
		} else if (nums[mid] < value) { // Check further up in the array
			return firstNonSmallerIndex(nums, value, mid + 1, max);
		} else { // nums[mid] > value OR we're on the value, but not at the first occurrence of it!
			return firstNonSmallerIndex(nums, value, min, mid - 1);
		}
	}
	
	// Make a sorted array of randomly generated numbers.
	// Code provided by instructor
	public static int[] createRandomSortedArray(int size) {
	    Random rand = new Random();
	    int[] array = new int[size];
	    
	    for (int i = 0; i < size; i++) {
	        // pick random numbers (subtract a bit so that some 
	        // are negative)
	        array[i] = rand.nextInt(size * 3) - size / 4;
	    }
	    
	    Arrays.sort(array);
	    return array;
	}
	
	// Call firstNonSmallerIndex a number of times to find the average runtime for the given
	// array size, and print the results to the console.
	public static double test(int n) {
		// Create a random, sorted array to play with
		int[] nums = createRandomSortedArray(n);

		// Find average runtime by summing all runtimes and diving by number of runs
		double sum = 0;
		for (int i = 0; i < NUM_SAMPLES; i++) {
			long startTime = System.nanoTime();
			firstNonSmallerIndex(nums, INT);
			sum += System.nanoTime() - startTime;
		}
		double elapsed = sum / NUM_SAMPLES;

		// report and return results
		System.out.println("for n = " + n + ", time = " + elapsed + "ns");
		System.out.println();
		return elapsed;
	}
}