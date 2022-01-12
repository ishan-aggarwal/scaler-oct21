package second;

// https://www.scaler.com/test/9662409d2b/?signature=BAhpA%2BC3FQ%3D%3D--7f18a69fc221ce80ba06cf64a570c1b21101ffe0#/index

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class ValidateBST {
	public int isValidBST(TreeNode A) {

		// base condition
		if (A == null) {
			return 1;
		}

		TreeNode temp = A;

		// check for right most element of left sub tree
		if (A.left != null) {
			temp = A.left;
			while (temp.right != null) {
				temp = temp.right;
			}

			if (temp.val >= A.val) {
				return 0;
			}
		}

		// check for left most element of right sub tree
		if (A.right != null) {
			temp = A.right;
			while (temp.left != null) {
				temp = temp.left;
			}

			if (temp.val <= A.val) {
				return 0;
			}
		}

		// call isValidBST on left and right sub tree
		if ((isValidBST(A.left) == 1) && (isValidBST(A.right) == 1)) {
			return 1;
		} else {
			return 0;
		}

	}
}
