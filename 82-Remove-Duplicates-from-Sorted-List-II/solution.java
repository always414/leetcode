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
        dummy.next = head;
        ListNode pre = dummy;
        
        int lastNumber = head.val;
        int count = 1;
        ListNode pointer = head.next;
        
        // 1 -> 2 -> 3
        while (pointer != null) {
        	if (lastNumber == pointer.val) {
        		pointer = pointer.next;
        		count ++;
        	} else {
        		if (count == 1) {
        			pre = pre.next;
        		} else {
        			pre.next = pointer;
        		}
        		
        		lastNumber = pointer.val;
        		pointer = pointer.next;
        		count = 1;
        	}
        }
        
        if (count > 1) {
        	pre.next = pointer;
        }
        
        return dummy.next;
    }
}