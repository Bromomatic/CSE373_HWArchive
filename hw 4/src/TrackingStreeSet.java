// Shawn Stern - 0921475 - CSE 373, Spring 2012 - Homework 4 Step 1

public class TrackingStreeSet extends StreeSet{
	
	// Return the height of the given BST node.
	// Height is -1 if empty, 0 if a single node, or the height of the tallest child
	// +1 if the BST contains multiple nodes.
	protected static int computeHeight(StreeNode node) {
		if(node == null) {
			return -1; // If empty, return -1
		} else {
			// Else, return height of tallest child + 1 using the height values
			// stored in the nodes. This also checks for height = 0.
			return Math.max(height(node.left), height(node.right)) + 1;
		}
	}	
	
	// Helper height method to simplify boolean statements in rest of code by
	// returning -1 when a null node is encountered, and the height otherwise.
	private static int height(StreeNode node) {
		return node == null ? -1 : node.height; // Hot damn, ternary in my code?!
	}
	
	// Overrides the recursive helper for add. Adds the given value to the BST, and
	// also maintains the height of each affected node in the tree.
	protected StreeNode add(StreeNode node, String value) {
		node = super.add(node, value);
		// Update the height now that the node is added
		node.height = computeHeight(node);
		return node;
	}
	
	// Overrides the recursive helper for remove. Removes the given value from the BST, 
	// and also maintains the height of each affected node in the tree.
	protected StreeNode remove(StreeNode node, String value) {
		node = super.remove(node, value);
		// Update the height of the node now, unless it has been removed and is null
		// to avoid NullPointerExceptions
		if (node != null) {
			node.height = computeHeight(node);
		}
		return node;
	}
		
	// Overrides the original recursive helper for toString, modifying the method to return
	// both the data of each node and its respective height.
	// Format is: [(data - height), ...] 
	protected String toString(StreeNode node) {
		String str = "";
		
		if (node != null) {
			str += toString(node.left);
			str += "(" + node.data + " - " + node.height + "), ";
			str += toString(node.right);
		}
		
		return str;
	}
	
	// Returns the balance factor of the given node.
	protected static int balanceFactor(StreeNode node) {
		// Return balance factor of 0 if the node is null or if it has no children
		if (node == null || node.left == null && node.right == null) {
			return 0;
		} else {
			// Otherwise, BFactor = right.height - left.height
			return height(node.right) - height(node.left);
		}		
	}
	
	// Return true if entire BST is balanced, false otherwise.
	public boolean isBalanced() {
		return isBalanced(root);
	}
	
	// Private helper to determine if the entire BST is balanced.
	private boolean isBalanced(StreeNode node) {
		// Null node is technically balanced (also serves as recursive base case)
		if (node == null) {
			return true;
		}
		
		// Tree is balanced if balance factor is -1, 0, or 1, and all children are
		// also balanced. Determine with absolute value and recursive calls.
		if (Math.abs(balanceFactor(node)) <= 1 && isBalanced(node.left) && 
				isBalanced(node.right)) {
			return true;
		} else {
			return false;
		}	
	}
}