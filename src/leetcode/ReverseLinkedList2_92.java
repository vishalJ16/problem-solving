package leetcode;

/**
 * @author v0j008y 25 Oct 2021 23:45:09
 */
public class ReverseLinkedList2_92 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		int left = 2;
		int right = 4;
//		reverseBetween(head, left, right);
//		reverseBasicUsingRecursion(head);
		reverse(head);
		System.out.println();
	}

	static ListNode reverseBetween(ListNode head, int left, int right) {
		/*
		 * Different test scenarios -
		 * 1. left = right,
		 * 2. left = first_node, right = last_node
		 * 3. left = not first node, right = last_node
		 * 4. left = first_node, right = not last node
		 * 5. left != first_node && right != last_node && left != right
		*/
		int count = 1;
		ListNode temp = head;
		ListNode before = new ListNode(-1);

		while (count < left) {
			count++;
			before = temp;
			temp = temp.next;
		}
		// before - 1
		ListNode first = temp; // 2

		ListNode prev = temp; // 2
		temp = temp.next; // 3
		// left = 2, right = 4
		while (left < right) {
			ListNode next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
			left++;
		}

		// left = right = 4
		// prev = 4, temp = 5
		// 2<-3<-4

		before.next = prev;
		first.next = temp;

		return first == head ? prev : head;
	}
	
	static ListNode reverseBasicUsingRecursion(ListNode head) {
		ListNode res = reverse(head, head);
		while(res != null) {
			System.out.println(head.val);
			res = res.next;
		}
		return head;
	}
	
	private static ListNode reverse(ListNode head, ListNode temp) {
		if(head == null) {
			return temp;
		}
		temp = reverse(head.next, temp);
		int aux = head.val;
		head.val = temp.val;
		temp.val = aux;
		if(temp.next == null) {
			return head;
		}
		return temp.next;
	}
	
	static ListNode reverse(ListNode head) {
		if(head == null) {
			return head;
		}

		// last node or only one node
		if(head.next == null) {
			return head;
		}

		ListNode newHeadNode = reverse(head.next);

		// change references for middle chain
		head.next.next = head;
		head.next = null;

		// send back new head node in every recursion
		return newHeadNode;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
