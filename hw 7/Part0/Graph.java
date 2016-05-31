import java.util.Collection;
import java.util.HashMap;

// Shawn Stern - 0921475 - CSE 373, Spring 2012 - Homework 7 Step 0

public class Graph<V, E> extends AbstractGraph<V, E> {

	// Add the given vertex to the graph if it doesn't already exist in the graph.
	// Throws a NullPointerException if the passed object is null.
	public void addVertex(V v) {
		// Check if input is null, throw NullPointerException as appropriate.
		checkForNull(v);
		
		// If not already contained, put the vertex in with the addition of the
		// necessary HashMap and VertexInfo. Do nothing if already contained.
		if (!containsVertex(v)) {
			// Put v and its info into the adjacency map and vertex info map.
			adjacencyMap.put(v, new HashMap<V, EdgeInfo<E>>());
			vertexInfo.put(v, new VertexInfo<V>(v));
		}		
	}

	// Return true if the vertex is in the graph, false otherwise.
	public boolean containsVertex(V v) {		
		// If the vertex exists, it will be a key in the adjacencyMap.
		return adjacencyMap.containsKey(v);
	}

	// Return the collection of vertices that are connected to the given vertex if it 
	// exists in the graph.
	// Throws a NullPointerException if the given vertex is null.
	// Throws an IllegalArgumentException if the given vertex does not exist in the map.
	public Collection<V> neighbors(V v) {
		// Check the vertex and throw the appropriate exceptions as needed.
		checkVertex(v);
		
		// Get the map of vertices connected to this node. The keyset of this map is all
		// vertices its connected to, and a Set extends Collection so this shouldn't cause errors.
		return adjacencyMap.get(v).keySet();
	}

	// Connect the two given vertices using the given edge, giving the edge a default weight of 1.
	// Throws a NullPointerException if either vertex is null.
	// Throws an IllegalArgumentException if either vertex is not in the graph.
	public void addEdge(V v1, V v2, E e) {
		// Exact same behavior as the larger add edge method, using default weight of 1.
		addEdge(v1, v2, e, 1);
	}

	// Connect the two given vertices using the given edge and weight.
	// Throws a NullPointerException if either vertex is null.
	// Throws an IllegalArgumentException if either vertex is not in the graph,
	// or if the weight is negative.
	public void addEdge(V v1, V v2, E e, int weight) {		
		// Throw NullPointerException if e is null, since checkVertices only checks v1 and v2.
		if (e == null) {
			throw new NullPointerException();
		}
		
		// Check to make sure that the weight is valid as well.
		if (weight < 0) {
			throw new IllegalArgumentException();
		}
		
		// If there is already an edge connecting the two, we need to take that old edge
		// out of the edge list to keep from having duplicates. 
		// This call to containsEdge also takes care of needing to check for exceptions,
		// since the containsEdge code automatically calls checkVerticies.
		if (containsEdge(v1, v2)) {
			edgeList.remove(adjacencyMap.get(v1).get(v2).e);
		}

		// Add v2 and its edge info to v1's map, and repeat in the reverse order since the 
		// graph is undirected. Also add the edge to the edgeList.
		// This action will always override existing mappings (behavior of put
		// according to Java API).
		adjacencyMap.get(v1).put(v2, new EdgeInfo<E>(e, weight));
		adjacencyMap.get(v2).put(v1, new EdgeInfo<E>(e, weight));
		edgeList.add(e);		
	}

	// Returns true if there is an edge connecting the given vertices, false otherwise.
	public boolean containsEdge(V v1, V v2) {
		// Check vertices just to be safe even though the spec doesn't mention it.
		checkVertices(v1, v2);
		
		// If there is an edge from v1 to v2, then v2 will be contained in the mapping
		// of vertices to hashtables that v1 maps to.
		return adjacencyMap.get(v1).containsKey(v2);
	}

	// Returns the edge connecting the given vertices if they're connected, or null if not.
	// Throws a NullPointerException if either vertex is null.
	// Throws an IllegalArgumentException if either vertex is not in the graph.
	public E edge(V v1, V v2) {
		// Call to checkVerticies is accomplished by calling containsEdge,
		// so no need to repeat it here!
		
		// Pull the E object from EdgeInfo of v2.
		// If they aren't connected, just return null.
		return containsEdge(v1, v2) ? adjacencyMap.get(v1).get(v2).e : null;
	}

	// Return the weight of the edge the connects the given vertices, if they are connected.
	// Throws a NullPointerException if either vertex is null.
	// Throws an IllegalArgumentException if either vertex is not in the graph.
	public int edgeWeight(V v1, V v2) {
		// Check the vertices and throw the appropriate exceptions as needed.
		checkVertices(v1, v2);
		
		// Throw an IllegalArgumentException if the two edges aren't connected by an edge.
		if (!containsEdge(v1, v2)) {
			throw new IllegalArgumentException();
		}
		
		// Return the weight of the edge, even if it could hurt that edge's feelings.
		return adjacencyMap.get(v1).get(v2).weight;		
	}
}