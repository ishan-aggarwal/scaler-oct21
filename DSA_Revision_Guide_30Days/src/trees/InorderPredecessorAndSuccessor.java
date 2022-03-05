package trees;

// https://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/
// Tree is BST
// So, we will use this property to move left or right in the tree

class InorderPredecessorAndSuccessor {

	// BST Node
	static class Node {
		int data;
		Node left, right;

		public Node() {
		}

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	static Node pre = new Node(), succ = new Node();

	// This function finds predecessor and
	// successor of key in BST. It sets pre
	// and suc as predecessor and successor
	// respectively

	static void findPreSuc(Node root, int key) {
		// Base case
		if (root == null)
			return;

		// If key is present at root
		if (root.data == key) {

			// The maximum value in left
			// subtree is predecessor
			if (root.left != null) {
				Node tmp = root.left;
				while (tmp.right != null) {
					tmp = tmp.right;
				}
				pre = tmp;
			}

			// The minimum value in
			// right subtree is successor
			if (root.right != null) {
				Node tmp = root.right;
				while (tmp.left != null) {
					tmp = tmp.left;
				}
				succ = tmp;
			}
			return;
		}

		// If key is smaller than
		// root's key, go to left subtree
		if (root.data > key) {
			succ = root;
			findPreSuc(root.left, key);
		} else { // Go to right subtree
			pre = root;
			findPreSuc(root.right, key);
		}
	}

	// A utility function to insert a
	// new node with given key in BST
	private static Node insert(Node node, int key) {
		if (node == null) {
			return new Node(key);
		}
		if (key < node.data) {
			node.left = insert(node.left, key);
		} else {
			node.right = insert(node.right, key);
		}
		return node;
	}

	// Driver code
	public static void main(String[] args) {

		// Key to be searched in BST
		int key = 65;

		/*
		 * Let us create following BST 50 / \ 30 70 / \ / \ 20 40 60 80
		 */

		Node root = new Node();
		insert(root, 50);
		insert(root, 30);
		insert(root, 20);
		insert(root, 40);
		insert(root, 70);
		insert(root, 60);
		insert(root, 80);

		findPreSuc(root, key);
		if (pre != null)
			System.out.println("Predecessor is " + pre.data);
		else
			System.out.println("No Predecessor");

		if (succ != null)
			System.out.println("Successor is " + succ.data);
		else
			System.out.println("No Successor");
	}
}