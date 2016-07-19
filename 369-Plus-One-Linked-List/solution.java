/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
    	if (head == null) 
    		return head;
    	
    	//reverse list
    	head = reverse(head);

    	// plus one
    	int carry = 1;
    	ListNode curr = head;
    	while (curr != null && carry != 0) {
    		int digit = curr.val + carry;
    		if (digit < 10) {
    			curr.val = digit;
    			carry = 0;
    		} else {
    			curr.val = digit % 10;
    			carry = 1;
    		}
    		
    		if (curr.next == null && carry == 1) {
    			curr.next = new ListNode(carry);
    			carry = 0;
    		}
    		curr = curr.next;
    	}
    	
    	//reverse list
    	return reverse(head);
    	
    }
    
    private ListNode reverse(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode newHead = null;
    	
    	while (head != null) {
    		ListNode next = head.next;
    		head.next = newHead;
    		newHead = head;
    		head = next;
    	}
    	
    	return newHead;
    }
}