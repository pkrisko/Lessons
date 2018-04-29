package dijkstras;

public class AdjacencyList {

	public DijkstraList[] vertices;
	private int size;
	
	public AdjacencyList(int numVertices) {
		/* Pass in a number of vertices, create nodes from A - ... */
		this.vertices = new DijkstraList[numVertices];
		this.size = 0;
		for (int idx = 0, chardx = 65; idx < vertices.length; idx++, chardx++) {
			this.size++;
			this.vertices[idx] = new DijkstraList((char) chardx);
		}
	}
	
	public void add(char from, char to, int weight) {
		for (int idx = 0; idx < vertices.length; idx++) {
			if (vertices[idx].getLetter() == from) {
				vertices[idx].add(weight, to);
			}
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public DijkstraList getEdges(char value) {
		for (int idx = 0; idx < size; idx++) {
			if (vertices[idx].getLetter() == value)
				return vertices[idx];
		}
		return null;
	}
	
	
	public String toString() {
		StringBuffer s = new StringBuffer();
		for (int idx = 0; idx < vertices.length; idx++) {
			s.append("\n");
			s.append("Node: " + vertices[idx].getLetter() + "\n");
			s.append("Edges: " + vertices[idx].toString() + "\n\n");
		}
		return s.toString();
	}
	
}
