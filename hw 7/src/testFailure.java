
public class testFailure {
	
	public static void main(String[] args) {
		Graph<String, String> test = new Graph<String, String>();
		
		String a = "lol";
		String b = "wat";
		
		test.addVertex(a);
		
		System.out.println(test.containsVertex(a));
		System.out.println(test.containsVertex("lol"));
		System.out.println(a);
		System.out.println();
		test.addVertex(a);
		test.addVertex(b);
		System.out.println(test);
		
		System.out.println();
				
		String c = "dummy";
		test.addEdge(a, b, c, 5);
		System.out.println(test);
		
		System.out.println();
		
		String d = "cocks";
		String f = "tats";
		test.addVertex(d);
		test.addEdge(a, d, f);
		System.out.println(test);
		
		System.out.println();
		
		System.out.println(test.containsEdge(a,d));
		System.out.println(test.containsEdge(d,a));
		System.out.println(test.edgeWeight(a,b));
		
		String x = test.edge(a,d);
		System.out.println(x);
		System.out.println();
		
		System.out.println(test.edges());
		System.out.println();
		System.out.println(test.vertices());
		System.out.println();
		System.out.println(test.neighbors(a));
		
		System.out.println();
		
		test.addEdge(a, b, c, 3);
		System.out.println(test);
		System.out.println();
		System.out.println(test.edgeWeight(a,b));	
		
		String h = "Van";
		String i = "wubs";
		String j = "I";
		String k = "boop";
		
		
		test.addVertex(h);
		test.addVertex(i);
		
		test.addEdge(h, i, j, 4);
		test.addEdge(a, i, k, 6);
		System.out.println();
		System.out.println(test);
		
		System.out.println(test.containsEdge(a,i));
		System.out.println(test.edgeWeight(a,i));
		System.out.println(test.neighbors(a));
		System.out.println(test.neighbors("wubs"));
		System.out.println(test.neighbors("Van"));
		
		// Check to make sure edge is also overwritten
		String o = "hi";
		test.addEdge(a, b, i, 5);
		System.out.println(test);
		test.addEdge(a, b, o, 5);
		System.out.println(test);
		test.addEdge(h, i, o, 4);
		System.out.println(test);
		test.addEdge(h, i, a, 10);
		System.out.println(test);
		
	}
}
