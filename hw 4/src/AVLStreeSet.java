// Shawn Stern - 0921475 - CSE 373, Spring 2012 - Homework 4 Step 2

public class AVLStreeSet extends TrackingStreeSet{
	
	// Right rotates the given node to fix the LL case.
	private StreeNode rightRotate(StreeNode parent) { 
	    // 1. detach left child's right subtree 
	    StreeNode leftright = parent.left.right; 
	    
	    // 2. consider left child to be the new parent 
	    StreeNode newParent = parent.left; 
	    
	    // 3. attach old parent onto right of new parent 
	    newParent.right = parent; 
	    
	    // 4. attach old left child's old right subtree as 
	    //    left subtree of new right child 
	    newParent.right.left = leftright; 
	    
	    parent.height = computeHeight(parent); 
	    
	    return newParent; 
	} 
	
	// Left rotates the given node to fix the RR case.	
	private StreeNode leftRotate(StreeNode parent) {
	    // 1. detach right child's left subtree 
	    StreeNode rightleft = parent.right.left; 
	    
	    // 2. consider right child to be the new parent 
	    StreeNode newParent = parent.right; 
	    
	    // 3. attach old parent onto left of new parent 
	    newParent.left = parent; 
	    
	    // 4. attach old left child's old left subtree as 
	    //    right subtree of new right child 
	    newParent.left.right = rightleft; 
	    
	    parent.height = computeHeight(parent); 
	    
	    return newParent;
	}
	
	// If the AVL Tree rooted at the given node is unbalanced by AVL
	// standards, rebalance the tree. 
	private StreeNode rebalance(StreeNode node) {
		// Determine balance factor of current node
		int bFactor = balanceFactor(node); 
        
		// Cover all cases, if balance factor is below -1 check for LL and LR cases,
		// fix as necessary with rotates.
		// Modifying the balance factor test from <0 to <= 0 and so forth
		// allows the code to accomodate all 6 cases simply.
        if (bFactor < -1) { 
        	if (balanceFactor(node.left) <= 0) {   	// case 1 (LL insert) 
        		node = rightRotate(node); 
        	} else {                              	// case 2 (LR insert) 
        		node.left = leftRotate(node.left); 
        		node = rightRotate(node); 
        	} 
        } else if (bFactor > 1) { 
             // take care of symmetric cases in a similar manner
        	if (balanceFactor(node.right) >= 0) {   
        		node = leftRotate(node); 
        	} else {                              	 
        		node.right = rightRotate(node.right); 
        		node = leftRotate(node); 
        	} 
        } 
        
        // Ensure that node height is corrected and inserted into node's height field,
        // Removes semi-redundant height computation in rotate left/right code from
        // instructor's slides (since that wasn't written for the other cases as well)
        if (node != null) {
        	node.height = computeHeight(node);
        }
        		
		return node;
	}
	
	// Add the given value to the tree (if not already in the set), and rebalance it.
	protected StreeNode add(StreeNode node, String value) {
		// x = change(x)
		node = super.add(node, value);
		// Rebalance the node
		node = rebalance(node);
		return node;
	}
	
	// Remove the given value from the tree (if it exists), and rebalance it.
	protected StreeNode remove(StreeNode node, String value) {
		// x = change(x)
		node = super.remove(node, value);
		// Rebalance the node
		node = rebalance(node);
		return node;
	}
}
