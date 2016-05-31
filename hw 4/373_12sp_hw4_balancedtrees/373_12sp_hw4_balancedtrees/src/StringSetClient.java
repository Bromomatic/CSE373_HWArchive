/**
 * CSE 373, Spring 2012
 * A basic client for you to use to fill in with the tests that you use to test
 * your StringSet code.
 */
public class StringSetClient {
	public static void main(String[] args) {
		// YOUR TESTS GO HERE!

		testAVLTreeSetRemoveRecursiveRebalance();
	}

	public static void testAVLTreeSetRemoveRecursiveRebalance() {
		TrackingStreeSet t = new AVLStreeSet();
		t.add("f");
		t.add("c");
		t.add("m");
		t.add("a");
		t.add("d");
		t.add("j");
		t.add("o");
		t.add("e");  
		t.add("g");
		t.add("n");
		t.add("r");
		t.add("s");

		// should look like: [(a - 0), (c - 2), (d - 1), (e - 0), (f - 4), (g - 0), (j - 1), (m - 3), (n - 0), (o - 2), (r - 1), (s - 0)]
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());

		System.out.println("Removing a...");
		t.remove("a");

		// should look like: [(c - 0), (d - 1), (e - 0), (f - 2), (g - 0), (j - 1), (m - 3), (n - 0), (o - 2), (r - 1), (s - 0)]
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());  
	}
}
