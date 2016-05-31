/**
 * This class represents a node for the linked list-based implementation of a 
 * DoubleStack.
 * @author Jessica Miller (minor modifications by Benson Limketkai)
 */
public class LinkedStackNode {
    public double value;		
    public LinkedStackNode next;
	
    public LinkedStackNode(double value) {
    	this(value, null);
    }
	
    public LinkedStackNode(double value, LinkedStackNode next) {
    	this.value = value;
    	this.next = next;
    }
}