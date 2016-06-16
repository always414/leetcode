/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while (l1 != null && l2 != null) {
        	if (l1.val <= l2.val) {
        		pointer.next = l1;
        		pointer = pointer.next;
        		l1 = l1.next;
        	} else {
        		pointer.next = l2;
        		pointer = pointer.next;
        		l2 = l2.next;
        	}
        }
        
        if (l1 != null) {
        	pointer.next = l1;
        }
        
        if (l2 != null) {
        	pointer.next = l2;
        }
        
        return dummy.next;
    }
}