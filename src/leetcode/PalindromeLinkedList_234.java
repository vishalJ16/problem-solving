/**
 * 
 */
package leetcode;

/**
 * @author v0j008y
 * 22 Sept 2021
 * 23:38:28
 */
public class PalindromeLinkedList_234 {

	/**
	 * @param args
	 */
	
//	static ListNode head;
	static ListNode originalHead;
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		
		boolean ans = isPalindrome(head);
		System.out.println(ans);
	}
	
    static boolean isPalindrome(ListNode head) {
        originalHead = head;
        return check(head);
    }
    
    static boolean check(ListNode curr) {
        if(curr == null) {
            return true;
        }
        if(check(curr.next)) {
            if(curr.val == originalHead.val) {
                originalHead = originalHead.next;
                return true;
            }
            return false;
        }
        return false;
        
    }
    
    static class ListNode {
    	int val;
    	ListNode next;
    	
        ListNode(int val) {
        	this.val = val;
        }
    }

}
