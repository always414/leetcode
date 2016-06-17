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
    	if (head == null) {
    		return null;
    	}
    	if (k == 0) {
    		return head;
    	}
    	
    	ListNode dummy = new ListNode(0);
    	
        ListNode fast = head, slow = head;
        
        while (k > 0) {
        	fast = fast.next;
        	k--;
        	// deal with some corner cases
        	if (fast == null && k == 0) {
        		return head;
        	}
        	
        	if (fast == null && k > 0) {
        		fast = head;
        	}
        }
        
       

        while (fast.next != null) {
        	fast = fast.next;
        	slow = slow.next;
        }
        
        dummy.next = slow.next;
        slow.next = null;
        fast.next = head;
        
        return dummy.next;
    	
    }
}