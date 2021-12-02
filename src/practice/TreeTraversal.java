/**
 * 
 */
package practice;

/**
 * @author v0j008y 2 Oct 2021 16:19:14
 */
public class TreeTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree root = new Tree("+");
		root.left = new Tree("*");
		root.right = new Tree("5");
		root.left.left = new Tree("4");
		root.left.right = new Tree("-");
		root.left.right.left = new Tree("7");
		root.left.right.right = new Tree("2");

		inorder(root);
		System.out.println();
		postorder(root);
	}

	static void inorder(Tree root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data);
			inorder(root.right);
		}
	}

	static void postorder(Tree root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data);
		}
	}
}

class Tree {
	String data;
	Tree left;
	Tree right;

	Tree(String data) {
		this.data = data;
	}
}
