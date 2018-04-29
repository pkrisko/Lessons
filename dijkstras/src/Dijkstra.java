package dijkstras;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Dijkstra {
	
	

	/**
	 * Improved implementation of Dijksktra's algorithm operating on an adjacency list,
	 * utilizing a min-heap priority queue.  See related classes in the package for
	 * specific implementations (AdjancencyList.java, PriorityQueue.java, Node.java, etc.) 
	 * 
	 * Each vertex has a char for its value, and the graph this operates on has no edges 
	 * below 0.  Any edge with a cost above Integer.MAX_VALUE
	 * will break this implementation.  Consider using a float instead.
	 * 
	 * @param al Adjacency List representation of our graph
	 * @param from The starting node from where we are beginning Dijkstra's
	 * @return A HashMap where each key representing a vertex is mapped to its total cheapest
	 * cost from the starting vertex, aka @param from.
	 */
	public static HashMap<Character, Integer> algorithmetize(AdjacencyList al, char from) {
		// Size is the number of nodes
		HashMap<Character, Integer> distances = new HashMap<Character, Integer>();
		// Keep track of vertices already visited
		ArrayList<Character> visited = new ArrayList<Character>();
		// Keep track of elements to visit in a modified min-heap structure
		// See implimentation in PriorityQueue.java in this package.
		PriorityQueue pq = new PriorityQueue();
		// Initialize each value's distance from A to infinity
		for (DijkstraList edgeList : al.vertices)
			distances.put(edgeList.getLetter(), Integer.MAX_VALUE);
		// Set A's cost to itself to 0
		distances.put(from, 0);
		// Add A to the priority queue with a value of 0, (maximum priority because minimum value)
		pq.add('A', 0);
		
		System.out.println("\n----- INITIALIZATION STATUS -----");
		System.out.println("DISTANCES: " + distances);
		System.out.println("PRIORITY QUEUE " + pq.queue);
		
		// While we have elements in our priority queue.
		while (!pq.empty()) {
			PriorityQueue.Node u = pq.poll();
			System.out.println("\n----- VISITING NEIGHBORS OF: " + u.getValue() + " -----");
			// Add char value to set of visited nodes
			visited.add(u.getValue());
			Node edge = al.getEdges(u.getValue()).head;
			while (edge != null) {
				distances.get(edge.getDestination());
				int costToU = distances.get(u.getValue());
				// The cost to get to the current node we are visiting
				int currDist = edge.getEdgeWeight();
				// The letter of where the edge goes
				char destination = edge.getDestination();
				System.out.println(destination);
				// If the total cost to get to this node is better than what we've seen so far...
				if (costToU + currDist < distances.get(destination)) {
					distances.put(destination, costToU + currDist);
					// If we haven't visited this node yet (and its neighbors)
					if (visited.contains(destination) == false) {
						// Add it to visited
						visited.add(destination);
						// Add it to the priority queue with its fancy new cost
						pq.add(destination, costToU + currDist);
					}
				}
				// Move the chains
				edge = edge.next;
			}
			System.out.println("UPDATED DISTANCES " + distances);
			System.out.println("PRIORITY QUEUE " + pq.queue);
			
		}
		
		return distances;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AdjacencyList al = new AdjacencyList(8);
		al.add('A', 'B', 20);
		al.add('A', 'D', 80);
		al.add('A', 'G', 90);
		al.add('B', 'F', 10);
		al.add('C', 'F', 50);
		al.add('C', 'H', 20);
		al.add('C', 'D', 10);
		al.add('D', 'C', 10);
		al.add('D', 'G', 20);
		al.add('E', 'G', 30);
		al.add('E', 'B', 50);
		al.add('F', 'C', 10);
		al.add('F', 'D', 40);
		al.add('G', 'A', 20);
		HashMap<Character,  Integer> results = algorithmetize(al, 'A');
		System.out.println(results);
		
//		System.out.println((char) 65);
		
		char[] arr = {'a','\0','1'};
		System.out.println("~!@#!@#!@#!@#");
		System.out.println(Arrays.toString(arr));
		System.out.println("~!@#!@#!@#!@#");
	}
	
}


