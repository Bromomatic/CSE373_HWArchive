/**
 * CSE 373, Spring 2012
 * This client tests the get and remove methods of the HashMap.  These are not
 * necessarily comprehensive tests, so you should add further tests to this file
 * for unchecked cases.
 */
public class HashMapClient {
	private static final String[] countries = {"United Arab Emirates", "Thailand", "Germany", "Brazil", "Hungary", "Wales", "Jamaica", "Nepal", null, "Vatican City"};
	private static final String[] capitals = {"Abu Dhabi", "Bangkok", "Berlin", "Brasilia", "Budapest", "Cardiff", "Kingston", "Kathmandu", "unknown", null};	
	
    public static void main(String[] args) {
        testGet();
        System.out.println();
        testRemove1();
        testRemove2();
    }
    
    public static void testGet() {
    	System.out.println("----- TESTING MAP'S GET METHOD -----");
    	
    	Map<String, String> m = populateMap();
    	
    	for (int i = 0; i < countries.length; i++) {
    		System.out.println(countries[i] + "'s capital is..." + m.get(countries[i]));
    	}
    	
    	System.out.println("Wales' capitol is " + m.get("Wales"));
    	System.out.println("xx capitol is " + m.get("null"));
    	
    	System.out.println();
    	m.print();
    }
    
    public static void testRemove1() {
    	System.out.println("----- TESTING MAP'S REMOVE METHOD -----");
    	
    	// Populate the map
    	Map<String, String> m = populateMap();
    	
    	// See that removing something also returns the right value
    	m.print();
    	System.out.println();
    	System.out.println(m.remove("Thailand"));
    	System.out.println();
    	// Show that it is also removed from map by printing
    	m.print();
    	System.out.println();
    	// Show that we can delete items from the end of a chain,
    	// in addition to duplicate removes on items
    	m.remove("Brazil");
    	m.print();
    	System.out.println();
    	m.remove("Germany");
    	m.print();
    	System.out.println();
    	m.remove("Jamaica");
    	m.print();
    	System.out.println();
    	m.remove("Jamaica");
    	m.print();
    	System.out.println();
    	m.remove("Germany");
    	m.print();
    	System.out.println();
    	m.remove("Germany");
    	m.print();
    	System.out.println();
    	// Show removal of the head of a chain, including the removal of null and the 
    	// attempt to remove null AGAIN
    	m.remove("Vatican City");
    	m.print();
    	System.out.println();
    	m.remove(null);
    	m.print();
    	System.out.println();
    	m.remove(null);
    	m.print();
    	System.out.println();
    	
    }  
    
    public static void testRemove2() {
    	System.out.println("----- TESTING MAP'S REMOVE METHOD AGAIN -----");
    	
    	// Populate the map
    	Map<String, String> m = populateMap();
    	
    	// See that removing something also returns the right value
    	m.print();
    	System.out.println();
    	System.out.println(m.remove(null));
    	System.out.println();
    	// Show that it is also removed from map by printing
    	m.print();
    	System.out.println();
    	// Show that we can delete items from the middle of a chain
    	System.out.println(m.remove("Hungary"));
    	m.print();
    	System.out.println();   
    	System.out.println(m.remove("Brazil"));
    	m.print();
    	System.out.println(); 
    	m.remove("Germany");
    	m.print();
    	System.out.println(); 
    }  
    
    private static Map<String, String> populateMap() {
    	Map<String, String> map = new HashMap<String, String>();
    	
    	for (int i = 0; i < countries.length; i++) {
    		map.put(countries[i], capitals[i]);
    	}
    	
    	return map;
    }
}
