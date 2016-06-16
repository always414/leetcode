/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	// n always valid
    	if (head == null) {
    		return null;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode fast = dummy, slow = dummy;
    	while (n > 0) {
    		fast = fast.next;
    		n--;
    	}
    	
    	while (fast.next != null) {
    		fast = fast.next;
    		slow = slow.next;
    	}
    	
    	slow.next = slow.next.next;
    	
    	return dummy.next;
    	
    }
}