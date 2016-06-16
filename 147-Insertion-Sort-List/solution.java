/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = null;

        while (head != null) {
        	ListNode toInsert = head;
        	head = head.next;
        	toInsert.next = null;
        	
        	sorted = insert(sorted, toInsert);
        }
        
        return sorted;
    }
    
    private ListNode insert(ListNode head, ListNode toInsert) {
    	if (head == null) {
    		return toInsert;
    	}
    	
    	if (head.val >= toInsert.val) {
    		toInsert.next = head;
    		return toInsert;
    	} else {
    		// pointer.val < toInsert.val
    		ListNode pointer = head;
    		while (pointer != null) {
    			if (pointer.next == null) {
    				pointer.next = toInsert;
    				break;
    			} else {
    				// pointer.next != null
    				if (pointer.next.val < toInsert.val) {
    					pointer = pointer.next;
    				} else {
    					toInsert.next = pointer.next;
    					pointer.next = toInsert;
    					break;
    				}
    			}
    		}
    	}
    	return head;
    	
    }
}