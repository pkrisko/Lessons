package dijkstras;

public class Node {
	
	public Node next;
	public int edgeWeight;
	public char destination;
	
	public Node(int edgeWeight, char destination) {
		this.edgeWeight = edgeWeight;
		this.destination = destination;
		this.next = null;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setNext(Node node) {
		this.next = node;
	}
	
	public int getEdgeWeight() {
		return this.edgeWeight;
	}
	
	public char getDestination() {
		return this.destination;
	}
	
}
