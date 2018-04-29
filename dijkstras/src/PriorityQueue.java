package dijkstras;

import java.util.ArrayList;

public class PriorityQueue {
	
	ArrayList<Node> queue;
	
	public PriorityQueue() {
		this.queue = new ArrayList<Node>();
	}
	
	class Node {
		char value;

		private int weight;
		
		Node (char value, int weight) {
			this.value = value;
			this.weight = weight;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}
		
		public char getValue() {
			return value;
		}

		public void setValue(char value) {
			this.value = value;
		}
		
		public String toString() {
			return "VALUE: " + this.value + " WEIGHT: " + this.weight;
		}
	}
	
	// Get the index of the parent element
	private int parent(int i) {
		// If i is already a root node index
		if (i == 0)
			return 0;
		
		return (i - 1) / 2;
	}
	
	// Get the index of the left child element
	private int LEFT(int i) {
		return (2 * i + 1);
	}
	
	// Get the index of the right child element
	private int RIGHT(int i) {
		return (2 * i + 2);
	}
	
	private void swap(int x, int y) {
		Node temp = queue.get(x);
		queue.set(x, queue.get(y));
		queue.set(y, temp);
	}
	
	public void setElementAt(int x, int y) {
		queue.set(x, queue.get(y));
	}
	
	private void heapify_down(int i) {
		int left = LEFT(i);
		int right = RIGHT(i);
		
		int smallest = i;
//		
//		System.out.println("LEFT:" + queue.get(left));
//		System.out.println("Right:" + queue.get(right));
//		System.out.println("SMALLEST:" + queue.get(smallest));
		
//		System.out.println(queue);
		
		if (left < size() && queue.get(left).weight < queue.get(i).weight) {
			smallest = left;
		}
		
		if (right < size() && queue.get(right).weight < queue.get(smallest).weight) {
			smallest = right;
		}
		
		if (smallest != i) {
//			System.out.println("SMALLEST DOES NOT77 EQUAL i");
			swap (i, smallest);
			heapify_down(smallest);
		}
	}
	
	private void heapify_up(int i) {
		
		if (i > 0 && queue.get(parent(i)).weight > queue.get(i).weight) {
			swap(i, parent(i));
			heapify_up(parent(i));
		}
		
	}
	
	public int size() {
		return queue.size();
	}
	

//	
	public void add(char value, int weight) {
		queue.add(new Node(value, weight));
		int index = size() - 1;
		heapify_up(index);
//		System.out.println(queue.toString());
	}
	
	private Node getLastElement() {
		return this.queue.get(this.queue.size() - 1);
	}
	
	public Node poll() {
		try {
			if (size() == 0) {
				throw new Exception("Index out of range(Heap underflow)");
			}
			Node root = queue.get(0);
			// Replace root of the heap with the last element of the array
			this.queue.set(0, getLastElement());
			// Remove last element
			this.queue.remove(this.queue.size() - 1);
			
			heapify_down(0);
			
			return root;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Node peek() {
		try {
			if (size() == 0)
				throw new Exception("Index out of range(Heap underflow)");
			
			return this.queue.get(0);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void clear() {
		System.out.println("Emptying queue: ");
		while (!queue.isEmpty()) {
			System.out.print(poll() + " ");
		}
		System.out.println();
	}
	
	public boolean contains(char val) {
		for (int idx = 0; idx < this.queue.size(); idx++) {
			if (this.queue.get(idx).getValue() == val)
				return true;
		}
		return false;
	}
	
	
//	
	public boolean empty() {
		return this.queue.size() == 0;
	}
}