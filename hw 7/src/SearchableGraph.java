import java.util.*;

//Shawn Stern - 0921475 - CSE 373, Spring 2012 - Homework 7 Step 1

public class SearchableGraph<V, E> extends Graph<V, E> implements ISearchableGraph<V, E> {

	// Returns the path from v1 to v2 that has the lowest possible path weight, as a list. 
	// Returns a one-element list containing only v1 if the path from v1 to itself is
	// requested. If v2 is not reachable from v2, returns null.
	// If either vertex is null, throws a NullPointerException.
	// If either vertex is not in the graph, throws an IllegalArgumentException.
	public List<V> minimumWeightPath(V v1, V v2) {
		// Check vertices and throw exceptions as needed.
		checkVertices(v1, v2);
		
		// Reset the vertexInfo before each use of the algorithm.
		clearVertexInfo();	
		
		// Set starting location to distance 0.
		vertexInfo.get(v1).distance = 0;
		
		// Make a new ArrayList, and populate it with the graph's vertices.
		List<V> vertices = new ArrayList<V>();
		vertices.addAll(vertices());
		
		while (!vertices.isEmpty()) {
			// Look through the vertices to find the vertex with minimum distance.
			V v = vertices.get(0);
			for (V temp : vertices) {
				if (distance(temp) <= distance(v)) {
					v = temp;
				}
			}
			
			// We have the vertex with min distance; remove it, set as visited, and proceed.
			vertices.remove(v);
			vertexInfo.get(v).visited = true;
			
			for (V n : neighbors(v)) {
				// If not visited...
				if (!vertexInfo.get(n).visited) {
					// Get the weight of the edge from n to v.
					int edgeWeight = adjacencyMap.get(v).get(n).weight;
					
					// Store the current value of n's distance for comparison later.
					int currDistOfN = distance(n);
					
					// N's new distance is equal to least's distance + weight of edge from n to v.
					int newDistOfN = distance(v) + edgeWeight;
					
					if (newDistOfN < currDistOfN) {
						vertexInfo.get(n).distance = newDistOfN;
						vertexInfo.get(n).previous = v;
					}
				}
			}
		}
			
		// Return the path
		return pathConstruct(v1, v2);
	}
	
	// Returns the path from v1 to v2 that contains the fewest vertices. Requesting a path
	// from v1 to v1 will return a one-element list containing only v1. 
	// If either vertex is null, throws a NullPointerException.
	// If either vertex is not in the graph, throws an IllegalArgumentException.
	public List<V> shortestPath(V v1, V v2) {
		// Check vertices and throw exceptions as needed.
		checkVertices(v1, v2);
		
		// Reset the vertexInfo before each use of the algorithm.
		clearVertexInfo();		
		
		// Make a new list to store the BFS path, and insert v1.
		List<V> path = new ArrayList<V>();
		path.add(v1);
		
		// Visit v1
		vertexInfo.get(v1).visited = true;
				
		while (!path.isEmpty()) {
			V v = path.remove(0);
			if (v.equals(v2)) {
				// Path found. 
				// reconstruct path from v2 back to v1, following previous pointers.
				return pathConstruct(v1, v2);
			} else {
				// Visit each unvisited neighbor, set v as it's previous, and add it to 
				// the list so we can do a broader search.
				for (V n : neighbors(v)) {
					if (!vertexInfo.get(n).visited) {
						vertexInfo.get(n).visited = true;
						vertexInfo.get(n).previous = v;
						path.add(n);
					}					
				}
			}			
		}	
		
		// If we get to this point, no path: return null.
		return null;
	}
	
	// Returns if there is a path between v1 and v2. A vertex can reach itself.
	// If either vertex is null, throws a NullPointerException.
	// If either vertex is not in the graph, throws an IllegalArgumentException.
	public boolean reachable(V v1, V v2) {
		// The runtime of a BFS is O(|V| + |E|) and the runtime of reachable should also 
		// be O(|V| + |E|), so why not just use the code I've already written!?
		// Also, ternary for added allure. :)
		return (shortestPath(v1, v2) == null) ? false : true;
	}
	
	// ---------- Private Helper Methods ---------- //

	// Construct the path from v2 to v1 and return as a linked list.
	private List<V> pathConstruct(V v1, V v2) {
		LinkedList<V> path = new LinkedList<V>();
		path.addFirst(v2);
		
		// Return path in its current state if v1 = v2.
		if (v2.equals(v1)) {
			return path; 
		}		
		
		// Temporary variable to go backwards through the graph
		V curr = v2;
		
		if (!v2.equals(v1)) {
			// While there is still a previous V, add it to the front of the path list and 
			// move on to the next one.
			while (vertexInfo.get(curr).previous != null) {
				path.addFirst(vertexInfo.get(curr).previous);
				// Line for debugging
				// System.out.println(path);
				curr = vertexInfo.get(curr).previous;			
			}		
		}
				
		return path;
	}
	
	// Returns the distance value of the given vertex, improves code readability.
	private int distance(V v) {
		return vertexInfo.get(v).distance;
	}
}
