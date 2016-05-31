import java.util.*;
import java.io.*;

public class KevinBacon {
	// Because you guys love global variables.
	public static final String BACON = "Kevin Bacon"; 
	
    public static void main(String[] args) throws FileNotFoundException {
    	// Build graph of actors and their connections
        ISearchableGraph<String, String> graph = buildGraph();
        
        // Print out the intro text and user prompt
        System.out.println("Welcome to the Six Degrees of Kevin Bacon.");
        System.out.println("If you tell me an actor's name, I'll connect them " +
        		"to Kevin Bacon through");
        System.out.println("the movies they've appeared in.  " +
        		"I bet your actor has a Kevin Bacon number");
        System.out.println("of less than six!");
        System.out.println();
        System.out.print("Actor's name (or ALL for everyone)? ");
        
        // Make scanner and store user input
        Scanner console = new Scanner(System.in);
        String actor = console.nextLine();
        
        // Print output
        printBacon(actor, graph);
    }

    // Instructor code
    public static ISearchableGraph<String, String> buildGraph() throws FileNotFoundException {
        Scanner input = new Scanner(new File("movies.txt"));
        ISearchableGraph<String, String> graph = new SearchableGraph<String, String>();

        while (input.hasNextLine()) {
            Scanner line = new Scanner(input.nextLine()).useDelimiter(";");

            String movie = line.next();

            // get all of the actors in the movie
            List<String> actors = new ArrayList<String>();
            while (line.hasNext()) {
                String actor = line.next();
                graph.addVertex(actor);
                actors.add(actor);
            }

            // connect all of the actors
            for (int i = 0; i < actors.size(); i++) {
                for (int j = 1; j < actors.size(); j++) {
                    graph.addEdge(actors.get(i), actors.get(j), movie);
                }
            }

        }

        return graph;
    }
    
    // Print bacon chunks about actors 
    private static void printBacon(String actor, ISearchableGraph<String, String> graph) {
    	// Print output based on input
    	if (actor.equalsIgnoreCase("all")) {
    		// Go through all actors
    		Boolean firstLine = true;
    		for (String v : graph.vertices()) {
    			System.out.println();
    			printHelper(v, graph, graph.shortestPath(v, BACON), firstLine);
    			firstLine = false;
    		}
    	} else if (!graph.containsVertex(actor) || !graph.reachable(actor, BACON)){
    		// Cases when actor isn't real or if there's no path from bacon to the actor.
    		printHelper(actor, graph, null, false);    		
    	} else {
    		// Otherwise, just do the one actor.
    		printHelper(actor, graph, graph.shortestPath(actor, BACON), false);
    	}
    }
    
    // Helper to print information about an actor's baconness.
    private static void printHelper(String actor, ISearchableGraph<String, String> graph, 
    		List<String> path, Boolean firstLine) {
    	// Only print this line for normal lines of output (avoids fencepost)
    	if (!firstLine) {
    		System.out.println();
    	}
    	
    	System.out.println("Path from " + actor + " to " + BACON + ":");
    	
    	// Handle error messages, particularly useful for 'ALL' case
    	if (!graph.containsVertex(actor)) {
    		System.out.print("No such actor.");
    		return;
    	} else if (!graph.reachable(actor, BACON)) {
    		System.out.print("No path found.");
    		return;
    	}
    	
    	// Store the bacon number for later, since we dismantle the list next.
    	int baconNum = path.size() - 1;
    	
    	// Print out the meat of the bacon block.
    	while(path.size() > 1) {
    		// Print their relationship
            System.out.println(path.get(0) + " was in " + graph.edge(path.get(0), path.get(1)) + 
            		" with " + path.get(1));
            path.remove(0);
    	}
    	
        // Print out the Bacon number
        System.out.print(actor + "'s Bacon number is " + baconNum);
    }
}