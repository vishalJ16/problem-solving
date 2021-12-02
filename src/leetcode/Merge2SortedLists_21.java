/**
 * 
 */
package leetcode;

/**
 * @author v0j008y 10 Sept 2021 21:49:25
 */
public class Merge2SortedLists_21 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node l1 = new Node(1);
		l1.next = new Node(2);
		l1.next.next = new Node(4);

		Node l2 = new Node(1);
		l2.next = new Node(3);
		l2.next.next = new Node(4);

		Node res = mergeTwoLists(l1, l2);
		res = merge(l1, l2);
		res = mergeRecursive(l1, l2, new Node());
		print(res);
		System.out.println();
	}

	static Node mergeTwoLists(Node l1, Node l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		Node res = new Node();
		Node temp = res;

		while (l1 != null & l2 != null) {
			if (l1.val > l2.val) {
				res.next = new Node(l1.val);
				l1 = l1.next;
			} else {
				res.next = new Node(l1.val);
				l2 = l2.next;
			}
			res = res.next;
		}
		res.next = l1 == null ? l2 : l1;

		return temp.next;
	}

	static Node merge(Node l1, Node l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		Node res = new Node();
		Node temp = res;

		while (l1 != null & l2 != null) {
			if (l1.val >= l2.val) {
				res.next = l2;
				l2 = l2.next;
			} else {
				res.next = l1;
				l1 = l1.next;
			}
			res = res.next;
		}
		res.next = l1 == null ? l2 : l1;

		return temp.next;
	}
	
	static Node mergeRecursive(Node l1, Node l2, Node res) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		
		if(l1.val >= l2.val) {
			res = mergeRecursive(l1, l2.next, res.next);
		}
		else {
			res = mergeRecursive(l1.next, l2,res.next);
		}
		return res.next;
	}

	static class Node {
		int val;
		Node next;

		Node() {
		}

		Node(int val) {
			this.val = val;
		}
	}

	static void print(Node node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
