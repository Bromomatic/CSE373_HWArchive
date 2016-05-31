/**
 * CSE 373, Spring 2012
 * The StreeNode represents a single node in our String tree Set.
 */
public class StreeNode {
	public String data; 
	public StreeNode left;
	public StreeNode right;
	public int height;

	/**
	 * Constructs a leaf node with the given data.
	 */
	public StreeNode(String data) {
		this(data, null, null);
	}

	/**
	 * Constructs a leaf or branch node with the given data and links.
	 */    
	public StreeNode(String data, StreeNode left, StreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}    
}