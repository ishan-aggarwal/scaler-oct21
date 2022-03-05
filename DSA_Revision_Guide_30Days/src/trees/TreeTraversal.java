package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		TreeNode(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode leftNode1 = new TreeNode(10);
		TreeNode leftNode2 = new TreeNode(30);
		TreeNode leftNode3 = new TreeNode(40);
		TreeNode rightNode1 = new TreeNode(50);
		TreeNode rightNode2 = new TreeNode(60);
		TreeNode rightNode3 = new TreeNode(70);
		root.left = leftNode1;
		root.right = rightNode1;
		root.left.left = leftNode2;
		root.left.right = rightNode2;
		root.right.left = leftNode3;
		root.right.right = rightNode3;
		System.out.println("Pre-order: " + preorderTraversal(root));
		System.out.println("Post-order: " + postorderTraversal(root));
		System.out.println("In-order: " + inOrderTraversal(root));
	}

	private static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Stack<TreeNode> stack = new Stack<>();
		// only add the root to the stack
		stack.add(root);

		while (!stack.isEmpty()) {
			// pop the root element from the stack
			TreeNode current = stack.pop();

			// since we want to process left first and right after left
			// but since we are adding the results to the final list at 0th index every time
			// so we would like to process the right part first and then left part
			// so first push left in the stack
			// and then push right in the stack
			// so that they are popped out in the reverse order
			// and in result right would be pushed back
			if (current.left != null) {
				stack.add(current.left);
			}
			if (current.right != null) {
				stack.add(current.right);
			}

			// add the value to the result at the start every time as we wanted to get the
			// result in reverse order
//			result.add(0, current.value);
			result.add(current.value);
		}

		Collections.reverse(result);
		return result;
	}

	private static List<Integer> inOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		// point the current element to the root of the tree
		// use this current element to travel to the left most node of the tree
		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<>();

		while (current != null || !stack.isEmpty()) {

			// travel to the left most element of the tree
			while (current != null) {
				stack.add(current);
				current = current.left;
			}

			// pop the left most element now
			current = stack.pop();
			// add the value to result
			result.add(current.value);
			// and move to right side of the tree
			current = current.right;
		}
		return result;
	}

	private static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Stack<TreeNode> stack = new Stack<>();
		// only add the root to the stack
		stack.add(root);

		while (!stack.isEmpty()) {
			// pop the root element from the stack
			TreeNode current = stack.pop();
			// add the value to the result
			result.add(current.value);

			// since we want to process left first and right after left
			// so first push right in the stack
			// and then push left in the stack
			// so that they are popped out in the reverse order
			if (current.right != null) {
				stack.add(current.right);
			}
			if (current.left != null) {
				stack.add(current.left);
			}
		}
		return result;
	}
}