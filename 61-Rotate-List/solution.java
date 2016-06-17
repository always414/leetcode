/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
    	if (head == null || head.next == null) {
    		return null;
    	}
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
        ListNode fast = head, slow = head;
        
        while (k > 0) {
        	fast = fast.next;
        	k--;
        }
        
        while (fast.next != null) {
        	fast = fast.next;
        	slow = slow.next;
        }
        
        dummy.next = slow.next;
        fast.next = head;
        slow.next = null;
        
        return dummy.next;
    	
    }
}