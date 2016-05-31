/**
 * CSE 373, Spring 2012
 * A binary search tree implementation of a Set for Strings.
 * StreeSet = String Tree Set
 */
public class StreeSet implements StringSet {
	protected StreeNode root;
	protected int numElements;

	public StreeSet() {
		root = null;
		numElements = 0;
	}

	/**
	 * Adds a value to the StringTreeSet.
	 * @return true if the String was added; false if the String was already in the Set
	 */
	public boolean add(String value) {
		int oldSize = numElements;
		root = add(root, value);					// x = change(x)
		return oldSize < numElements;
	}

	protected StreeNode add(StreeNode node, String value) {
		if (node == null) {
			node = new StreeNode(value);
			numElements++;
		} else if (node.data.compareTo(value) == 0) {
			// do nothing, String was already in Set
		} else if (node.data.compareTo(value) > 0) {
			node.left = add(node.left, value);		// x = change(x)
		} else {
			node.right = add(node.right, value);	// x = change(x)
		}

		return node;
	}


	/**
	 * Searches for the specified String value in the Set.
	 * @return true if the value was found in the Set; false otherwise
	 */
	public boolean contains(String value) {
		return contains(root, value);
	}

	private boolean contains(StreeNode node, String value) {
		if (node == null) {
			return false;                              
		} else if (node.data.compareTo(value) == 0) {
			return true;
		} else if (node.data.compareTo(value) > 0) {
			return contains(node.left, value); 
		} else {
			return contains(node.right, value);
		}
	}


	/**
	 * Prints the BST sideways.
	 */
	public void print() {
		print(this.root, 0);    
	}


	/**
	 * Recursive print helper; in-order traversal.
	 * @param node
	 * @param level
	 */
	private void print(StreeNode node, int level) {
		if (node == null)
			return;
		else {
			print(node.right, level + 1);
			printTabs(level);
			System.out.println(node.data);
			print(node.left, level + 1);
		}
	}

	private void printTabs(int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("\t");
		}
	}


	/**
	 * Removes the given value from the Set.
	 * @return true if the value was found and removed from the Set; 
	 * 		   false if the value was not found in the Set
	 */
	public boolean remove(String value) {
		int oldSize = numElements;
		root = remove(root, value);
		return oldSize > numElements;
	}

	protected StreeNode remove(StreeNode node, String value) {
		if (node == null) {
			return node;
		} else if (node.data.compareTo(value) < 0) {
			node.right = remove(node.right, value);
		} else if (node.data.compareTo(value) > 0) {
			node.left = remove(node.left, value); 
		} else {
			if (node.right != null && node.left != null) {
				node.data = getMinValue(node.right);
				node.right = remove(node.right, node.data);
			} else if (node.right != null) { 
				node = node.right;
				numElements--;
			} else { 
				node = node.left; 
				numElements--;
			}
		} 

		return node;
	}	

	private String getMinValue(StreeNode node) {
		if (node.left == null) {
			return node.data;
		} else {
			return getMinValue(node.left);
		}
	}	


	/**
	 * The number of elements in the Set.
	 */
	public int size() {
		return numElements;
	}


	/**
	 * Returns a String representation of StringTreeSet with elements in
	 * their "natural order" (e.g., [Jake, Kasey, Marisa, Robert]).  This is
	 * an example of an in-order traversal.
	 */
	public String toString() {
		String str = "[" + toString(root);
		if (str.length() > 1) {
			// remove extra comma and space at end
			str = str.substring(0, str.length()-2);
		}
		return str + "]";
	}

	protected String toString(StreeNode node) {
		String str = "";
		if (node != null) {
			str += toString(node.left);
			str += node.data + ", ";
			str += toString(node.right);
		}
		return str;
	}
}
