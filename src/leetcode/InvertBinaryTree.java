/**
 * 
 */
package leetcode;

import leetcode.InsertIntoBST.TreeNode;

/**
 * @author v0j008y 16 Sept 2021 23:13:30
 */
public class InvertBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		invert(root);
		System.out.println();
	}

	static TreeNode invert(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode temp = root.left;
		root.left = invert(root.right);
		root.right = invert(temp);

		return root;
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
