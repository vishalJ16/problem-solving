/**
 * 
 */
package leetcode;

/**
 * @author v0j008y
 * 23 Sept 2021
 * 15:40:42
 */
public class KthSmallestInBST_230 {

	/**
	 * @param args
	 */
	
	static int smallCount;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
//		root.left = new TreeNode(3);
		
		int k = 3;
		int res = kthSmallest(root, k);
		System.out.println(res);
		
	}
	
    static int kthSmallest(TreeNode root, int k) {
        // List<Integer> list = new ArrayList<>();
        return find(root, k, -1);
    }
    
    static int find(TreeNode root, int k, int smallest) {
        if(smallCount == k) {
            return smallest;
        }
        if(root == null) {
            return -1;
        }
        int res = find(root.left, k, smallest);
        if(res == -1) {
            smallCount++;
            return find(root.right, k, root.val);
        }
        return res;
    }
    
    static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	
    	TreeNode(int val) {
    		this.val = val;
    	}
    }

}
