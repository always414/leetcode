/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if (headA == null || headB == null) {
    		return null;
    	}
    	
    	if (headA == headB) {
    		return headA;
    	}
    	
    	// make a cycle of list B
    	ListNode pointer = headB;
    	while (pointer.next != null) {
    		pointer = pointer.next;
    	}
    	pointer.next = headB; 
    	
    	// detect whether list A and B forms a list with cycle;
    	// same as cycle II
    	ListNode fast = headA, slow = headA;
    	while (fast != null) {
    		if (fast.next != null && fast.next.next != null) {
    			fast = fast.next.next;
    			slow = slow.next;
    			
    			//deal the case that cycle B embrace headA
    			// if then, A is the intersect point
    			if (slow == headA) {
    				pointer.next = null;
    				return headA;
    			}
    			
    			if (slow == fast) {
    				fast = headA;
    				while (true) {
    					fast = fast.next;
    					slow = slow.next;
    					
    					if (fast == slow) {
    						pointer.next = null;
    						System.out.println(slow);
    						return slow;
    					}
    				}
    			}
    		} else {
    			// no cycle
    			pointer.next = null; // reverse back to original status
    			return null;
    		}
    	}
    	
    	return null;
    }
}