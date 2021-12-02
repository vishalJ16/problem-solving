/**
 * 
 */
package leetcode;

/**
 * @author v0j008y
 * 1 Sept 2021
 * 17:47:12
 */
public class RemoveNthFromLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		
		int n = 2;
		remove(head, n);
		System.out.println();
	}
	
	static Node remove(Node head, int n) {
		if(head == null) {
			return null;
		}
        Node temp = head;
        int count = 1;
        
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        
        if(count < n) {
            return null;
        }
        if(count == n) {
            return head.next;
        }
        
        int prev = count - n;
        temp = head;
        while(prev > 1) {
            temp = temp.next;
            prev--;
        }
        temp.next = temp.next.next;
        return head;
	}

	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
}
