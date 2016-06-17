/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pointer = dummy;
        while (pointer.next != null && pointer.next.next != null) {
        	ListNode l1 = pointer.next;
        	ListNode l2 = pointer.next.next;
        	ListNode rest = l2.next;
        	
        	pointer.next = l2;
        	l2.next = l1;
        	l1.next = rest;
        	
        	pointer = l1;
        }
        
        return dummy.next;
    }
    
    
}