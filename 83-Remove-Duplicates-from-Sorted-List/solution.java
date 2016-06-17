/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        ListNode pre = dummy;
        
        dummy.next = head;
        
        int lastNumber = head.val;
        
        while (pointer != null) {
        	if (lastNumber == pointer.val) {
        		pointer = pointer.next;
        	} else {
        		pre.next = pointer;
        		lastNumber = pointer.val;
        	}
        }
        
        pre.next = pointer;
        
        return dummy.next;
    }
}