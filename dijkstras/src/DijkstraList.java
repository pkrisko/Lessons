package dijkstras;
import dijkstras.Node;

public class DijkstraList {

	public Node head;
	public char letter;
	
	public DijkstraList(char value) {
		this.head = null;
		this.letter = value;
	}
	
	public void add(int edgeWeight, char destination) {
		Node runner;
		Node newNode = new Node(edgeWeight, destination);
		if (this.head == null) {
			this.head = newNode;
		} else {
			runner = this.head;
			while (runner.getNext() != null)
				runner = runner.getNext();
			runner.setNext(newNode);
		}
	}
	
	public char getLetter() {
		return this.letter;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node runner = this.head;
		while (runner != null) {
			sb.append("\n > To: " + (char) runner.getDestination() + " | Weight: " + runner.getEdgeWeight());
			runner = runner.getNext();
		}
		return sb.toString();
	}
	
}
