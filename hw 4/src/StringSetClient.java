// Shawn Stern - 0921475 - CSE 373, Spring 2012 - Homework 4 Step ??? Test Code

/**
 * CSE 373, Spring 2012
 * A basic client for you to use to fill in with the tests that you use to test
 * your StringSet code.
 */
public class StringSetClient {
	public static void main(String[] args) {
		// YOUR TESTS GO HERE!

		// No particular ordering to tests, ie. test 1 doesn't necessarily test 'case 1' 
		// from the spec.
		
		// Basically, test the tracking tree to show that the input creates an imbalanced tree,
		// and show that the AVL version correctly fixes it and makes a balanced tree.
		// Also, use visual proof so balance can be seen and heights verified manually.
		// Make sure to run all of my own tests on both AVL and Tracking StreeSets.
		testAVLTreeSetRemoveRecursiveRebalance();
		System.out.println();
		System.out.println("/----------/");
		System.out.println();
		testTrackingTreeSetBalance1();
		System.out.println();
		testAVLTreeSetBalance1();
		System.out.println();
		System.out.println("/----------/");
		System.out.println();
		testTrackingTreeSetBalance2();
		System.out.println();
		testAVLTreeSetBalance2();
		System.out.println();
		System.out.println("/----------/");
		System.out.println();
		testTrackingTreeSetBalance3();
		System.out.println();
		testAVLTreeSetBalance3();
		System.out.println();
		System.out.println("/----------/");
		System.out.println();
		testTrackingTreeSetBalance4();
		System.out.println();
		testAVLTreeSetBalance4();
		System.out.println();
		System.out.println("/----------/");
		System.out.println();		
		
		testAVLTreeSetRemoveEmpty();
		System.out.println();
		System.out.println("/----------/");
		System.out.println();
		testAVLTreeSetAddDuplicates();
		System.out.println();
		System.out.println("/----------/");
		System.out.println();
		testAVLTreeSetAlphabet();
		System.out.println();
		System.out.println("/----------/");
		System.out.println();
		
		testTrackingTreeSetRemoveEmpty();
		System.out.println();
		System.out.println("/----------/");
		System.out.println();
		testTrackingTreeSetAddDuplicates();
		System.out.println();
		System.out.println("/----------/");
		System.out.println();
		testTrackingTreeSetAlphabet();
		System.out.println();
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
		t.print(); // verify tree looks right
		System.out.println();

		System.out.println("Removing a...");
		t.remove("a");

		// should look like: [(c - 0), (d - 1), (e - 0), (f - 2), (g - 0), (j - 1), (m - 3), (n - 0), (o - 2), (r - 1), (s - 0)]
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());  
		
		t.print(); //verify tree looks right, heights are corrected properly
	}
	
	// try RL case where right side heavily outbalances the left, trackingtree wont rebalance it,
	// so this shows that the AVL tree fixes the issue with rotations.
	// Check that heights are correct visually and with printouts.
	public static void testTrackingTreeSetBalance1() {
		TrackingStreeSet t = new TrackingStreeSet();
		t.add("b");
		t.add("a");
		t.add("d");
		t.add("c");
		t.add("e");
		t.add("f");
		t.add("g");
		t.add("x");
		t.add("z");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
	
	// try RL case where right side heavily outbalances the left
	public static void testAVLTreeSetBalance1() {
		TrackingStreeSet t = new AVLStreeSet();
		t.add("b");
		t.add("a");
		t.add("d");
		t.add("c");
		t.add("e");
		t.add("f");
		t.add("g");
		t.add("x");
		t.add("z");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
	
	// try case where left side is more than 2 longer than right side (multiple rotations)
	// tracking tree won't balance it, so this shows what AVl tree should fix and height checks
	public static void testTrackingTreeSetBalance2() {
		TrackingStreeSet t = new TrackingStreeSet();
		t.add("f");
		t.add("e");
		t.add("g");
		t.add("d");
		t.add("c");
		t.add("b");
		t.add("a");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
	
	// try case where left side is more than 2 longer than right side (multiple rotations)
	public static void testAVLTreeSetBalance2() {
		TrackingStreeSet t = new AVLStreeSet();
		t.add("f");
		t.add("e");
		t.add("g");
		t.add("d");
		t.add("c");
		t.add("b");
		t.add("a");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
	
	// try case where inside of left branch is imbalanced
	// tracking tree won't balance it, so this shows what AVL tree should fix and height checks
	public static void testTrackingTreeSetBalance3() {
		TrackingStreeSet t = new TrackingStreeSet();
		t.add("p");
		t.add("b");
		t.add("x");
		t.add("f");
		t.add("h");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
	
	// try previous case but with AVL tree to correctly balance
	public static void testAVLTreeSetBalance3() {
		TrackingStreeSet t = new AVLStreeSet();
		t.add("p");
		t.add("b");
		t.add("x");
		t.add("f");
		t.add("h");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
	
	// try case where inside of right branch is imbalanced
	// tracking tree won't balance it, so this shows what AVL tree should fix and height checks
	public static void testTrackingTreeSetBalance4() {
		TrackingStreeSet t = new TrackingStreeSet();
		t.add("p");
		t.add("b");
		t.add("t");
		t.add("s");
		t.add("q");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
	
	// try previous case but with AVL tree to correctly balance
	public static void testAVLTreeSetBalance4() {
		TrackingStreeSet t = new AVLStreeSet();
		t.add("p");
		t.add("b");
		t.add("t");
		t.add("s");
		t.add("q");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
	
	
	
	// try case where we remove from a set that's already empty
	public static void testAVLTreeSetRemoveEmpty() {
		TrackingStreeSet t = new AVLStreeSet();
		t.remove("a");
		t.remove("dang");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
	
	// try case where we remove from a set that's already empty
	public static void testAVLTreeSetAddDuplicates() {
		TrackingStreeSet t = new AVLStreeSet();
		t.add("a");
		t.add("b");
		t.add("b");
		t.add("a");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
	
	// see if the entire tree is balanced when alphabet is added in order,
	// because why not do more tests. tests tests tests.
	public static void testAVLTreeSetAlphabet() {
		TrackingStreeSet t = new AVLStreeSet();
		t.add("a");
		t.add("b");
		t.add("c");
		t.add("d");
		t.add("e");
		t.add("f");
		t.add("g");
		t.add("h");
		t.add("i");
		t.add("j");
		t.add("k");
		t.add("l");
		t.add("m");
		t.add("n");
		t.add("o");
		t.add("p");
		t.add("q");
		t.add("r");
		t.add("s");
		t.add("t");
		t.add("u");
		t.add("v");
		t.add("w");
		t.add("x");
		t.add("y");
		t.add("z");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
	
	
	
	// try case where we remove from a set that's already empty
	public static void testTrackingTreeSetRemoveEmpty() {
		TrackingStreeSet t = new TrackingStreeSet();
		t.remove("a");
		t.remove("dang");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
	
	// try case where we remove from a set that's already empty
	public static void testTrackingTreeSetAddDuplicates() {
		TrackingStreeSet t = new TrackingStreeSet();
		t.add("a");
		t.add("b");
		t.add("b");
		t.add("a");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
	
	// try case where we remove from a set with 
	public static void testTrackingTreeSetRemoves() {
		TrackingStreeSet t = new TrackingStreeSet();
		t.add("a");
		t.add("b");
		t.add("b");
		t.add("a");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
	
	// see if the entire tree is balanced when alphabet is added in order,
	// because why not do more tests. tests tests tests.
	public static void testTrackingTreeSetAlphabet() {
		TrackingStreeSet t = new TrackingStreeSet();
		t.add("a");
		t.add("b");
		t.add("c");
		t.add("d");
		t.add("e");
		t.add("f");
		t.add("g");
		t.add("h");
		t.add("i");
		t.add("j");
		t.add("k");
		t.add("l");
		t.add("m");
		t.add("n");
		t.add("o");
		t.add("p");
		t.add("q");
		t.add("r");
		t.add("s");
		t.add("t");
		t.add("u");
		t.add("v");
		t.add("w");
		t.add("x");
		t.add("y");
		t.add("z");
		
		System.out.println(t);
		System.out.println("Is t balanced? " + t.isBalanced());
		System.out.println();
		t.print();
	}
}
