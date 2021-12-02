/**
 * 
 */
package leetcode;

/**
 * @author v0j008y 29-Sep-2021 12:05:54 am
 */
public class SumOfRootToLeafBinary_1022 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0); // 10
		root.right = new TreeNode(1); // 11
		root.left.left = new TreeNode(0); // 100
		root.left.right = new TreeNode(1); // 101
		root.right.left = new TreeNode(0); // 110
		root.right.right = new TreeNode(1); // 111

		int ans = sumRootToLeaf(root);
		System.out.println(ans);
	}

	static int total;

	static int sumRootToLeaf(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return findSum(root, new StringBuilder(), 0);
	}

	static int findSum(TreeNode root, StringBuilder pathNodes, int curr) {
		if (root == null) {
			return 0;
		}
		pathNodes.append(root.val);
		curr = (curr << 1) | root.val;

		if (root.left == null && root.right == null) {
			total += curr;
			int v = getIntegerValue(pathNodes);
			pathNodes.setLength(pathNodes.length() - 1);
			return v;
		}
		int sum = findSum(root.left, pathNodes, curr);
		sum += findSum(root.right, pathNodes, curr);
		pathNodes.setLength(pathNodes.length() - 1);
		return sum;
	}

	static int getIntegerValue(StringBuilder sb) {
		return Integer.parseInt(sb.toString(), 2);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}
