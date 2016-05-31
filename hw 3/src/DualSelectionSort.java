import java.util.Arrays;
import java.util.Random;

// Shawn Stern - 0921475 - CSE 373, Spring 2012 - Homework 3 Part B

public class DualSelectionSort {
	
	public static final int NUM_SAMPLES = 10;
	
	public static void main(String[] args) {
		
		// Tests to determine external correctness before testing timing
		// -------------------------------------------------------------
//		int[] test1 = createRandomArray(5);
//		System.out.println(Arrays.toString(test1));
//		dualSelectionSort(test1);
//		System.out.println(Arrays.toString(test1) + " " + isSorted(test1));
//		
//		System.out.println();
//		
//		int[] test2 = createRandomArray(10);
//		System.out.println(Arrays.toString(test2));
//		dualSelectionSort(test2);
//		System.out.println(Arrays.toString(test2) + " " + isSorted(test2));
//		
//		System.out.println();
//		
//		int[] test3 = createRandomArray(13);
//		System.out.println(Arrays.toString(test3));
//		dualSelectionSort(test3);
//		System.out.println(Arrays.toString(test3) + " " + isSorted(test3));
//		
//		System.out.println();
//		
//		int[] test4 = createRandomArray(100);
//		System.out.println(Arrays.toString(test4));
//		dualSelectionSort(test4);
//		System.out.println(Arrays.toString(test4) + " " + isSorted(test4));
//		
//		System.out.println();
//		
//		int[] test5 = createRandomArray(1000);
//		System.out.println(Arrays.toString(test5));
//		dualSelectionSort(test5);
//		System.out.println(Arrays.toString(test5) + " " + isSorted(test5));
//		
//		System.out.println();
//		
		int[] test6 = createRandomArray(0);
		System.out.println(Arrays.toString(test6));
		dualSelectionSort(test6);
		System.out.println(Arrays.toString(test6) + " " + isSorted(test6));
		
		// -------------------------------------------------------------
		
		
		// Timing Tests
		// -------------------------------------------------------------
		test(0);
		test(10);
		test(100);
		test(1000);
		test(10000);
		//test(25000);
		//test(50000);
				
		// -------------------------------------------------------------
	}
	
	// Accepts an array of integers and sorts it in ascending order from least to greatest.
	public static void dualSelectionSort(int[] array) {
		// Figure out initial length of the array to be sorted
		int length = array.length;
		
		// Sort should take length/2 iterations to sort, so that's the limit of the loop.
		for (int i = 0; i < length / 2; i++) {
			
			// Set min and max to the start of the sorted section, since they haven't
			// been determined yet
			int min = i, max = i;
			
			// Iterate over the array to find the min and max indices
			for (int j = i; j < length - i; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
				
				if (array[j] > array[max]) {
					max = j;
				}				
			}
			
			// Swap the smallest element in the array with the smallest index that
			// is still unsorted
			swap(array, i, min);
			
			// If max and min indices are the same, the previous swap just swapped the min
			// and max so that the largest value is at the front of the sorted section! 
			if (max == i) {
				// Swap them so that the max is where it belongs!
				swap(array, length - 1 - i, min);
			} else {
				// Otherwise, swap the largest element with the last unsorted index in the array
				swap(array, length - 1 - i, max);
			}
			
			// Just for testing so I can see the sorting in progress
			//System.out.println(Arrays.toString(array));	
		}
	}
	
	// Swap two elements in an array
	// Code provided by instructor
	private static void swap(int[] nums, int i, int j) {
		if (i == j) {
			return;
		}

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	// Returns true if array a's elements are in sorted order.
	// Code provided by instructor
	private static boolean isSorted(int[] a) {
	    for (int i = 0; i < a.length - 1; i++) {
	        if (a[i] > a[i+1]) {
	            return false;
	        }
	    }
	  
	    return true;
	}
	
	// Make an array of randomly generated numbers.
	// Code provided by instructor
	public static int[] createRandomArray(int size) {
	    int[] array = new int[size];
	    Random rand = new Random();
	    
	    // fill it with random data in [0, size]
	    for (int i = 0; i < size; i++) {
	        // pick random numbers (subtract a bit so that some 
	        // are negative)
	        array[i] = rand.nextInt(size * 3) - size / 4;
	    }
	    
	    return array;
	}
	
	// Selection sort code from lecture, used to compare against dualSelectionSort
	public static void selectionSort(int[] a) { 
	    for (int i = 0; i < a.length; i++) { 
	        // find index of smallest element 
	        int min = i; 
	        for (int j = i + 1; j < a.length; j++) { 
	            if (a[j] < a[min]) { 
	                min = j; 
	            } 
	        } 
	        // swap smallest element with a[i] 
	        swap(a, i, min); 
	    } 
	}
	
	// Tests the array
	public static void test(int n) {
		// Create a random, sorted array to play with
		int[] nums1 = createRandomArray(n);
		int[] nums2 = Arrays.copyOf(nums1, nums1.length);

		// Find average runtime by summing all runtimes and diving by number of runs
		double sum1 = 0;
		for (int i = 0; i < NUM_SAMPLES; i++) {
			long startTime = System.nanoTime();
			dualSelectionSort(nums1);
			sum1 += System.nanoTime() - startTime;
		}
		double elapsed1 = sum1 / NUM_SAMPLES;
		
		double sum2 = 0;
		for (int i = 0; i < NUM_SAMPLES; i++) {
			long startTime = System.nanoTime();
			selectionSort(nums2);
			sum2 += System.nanoTime() - startTime;
		}
		double elapsed2 = sum2 / NUM_SAMPLES;

		// report and return results for both sort types
		System.out.println("for n = " + n + ", time = " + elapsed1 + "ns - DualSelectionSort");
		System.out.println("for n = " + n + ", time = " + elapsed2 + "ns - SelectionSort");
		System.out.println();
	}
}
