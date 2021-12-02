/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author v0j008y 9 Sept 2021 18:54:31
 */
public class PopulateRightPointer_116 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node connect(Node root) {
		if (root == null) {
			return null;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			List<Node> temp = new ArrayList<>();
			while (q.peek() != null) {
				Node node = q.poll();
				temp.add(node);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
			temp.add(q.poll());

			for (int i = 0; i < temp.size() - 1; i++) {
				Node start = temp.get(i);
				Node next = temp.get(i + 1);
				start.right = next;
			}

			if (!q.isEmpty()) {
				q.add(null);
			}
		}
		return root;
	}

	class Node {
		int val;
		Node left;
		Node right;
		Node next;
	}
}
