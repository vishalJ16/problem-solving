/**
 * 
 */
package leetcode;

/**
 * @author v0j008y 15 Sept 2021 23:18:34
 */
public class InsertIntoBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		insertIntoBST(root, 5);
	}

	static TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (val > root.val) {
			root.right = insertIntoBST(root.right, val);
		}
		if (val < root.val) {
			root.left = insertIntoBST(root.left, val);
		}
		return root;
	}

	static void insert(TreeNode root, int val) {
		if (val > root.val) {
			if (root.right == null) {
				root.right = new TreeNode(val);
				return;
			}
			insert(root.right, val);
		}
		if (val < root.val) {
			if (root.left == null) {
				root.left = new TreeNode(val);
				return;
			}
			insert(root.left, val);
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}
	}
}
