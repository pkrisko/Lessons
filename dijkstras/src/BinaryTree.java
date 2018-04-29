package dijkstras;

public class BinaryTree {

	// Root of the Binary Tree
	public Node root;

	public BinaryTree() {
		root = null;
	}

	class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	/* function to print level order traversal of tree */
	void printLevelOrder() {
		int h = height(root);
		int i;
		for (i = 0; i < h; i++)
			printGivenLevel(root, i);
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest path
	 * from the root node down to the farthest leaf node.
	 */
	int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print nodes at the given level */
	void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 0)
			System.out.print(root.data + " ");
		else if (level > 0) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}
	/* Driver program to test above functions */

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		System.out.println(tree);
		tree.root = tree.new Node(1);
		// tree.root = new Node(1);
		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(3);
		tree.root.left.left = tree.new Node(4);
		tree.root.left.right = tree.new Node(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
	}
}
