/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode pointer = res;
        int carry = 0;
        
        int digit = 0;
        
        while (l1 != null || l2 != null) {
        	if (l1 != null && l2 != null) {
        		digit = l1.val + l2.val;
        	} else if (l1 != null && l2 == null) {
        		digit = l1.val;
        	} else if (l1 == null && l2 != null) {
        		digit = l2.val;
        	} else {
        		break;
        	}
        	
        	digit += carry; 
        	if (digit >= 10) {
        		carry = 1;
        		digit %= 10;
        	} else {
        		carry = 0;
        	}
        	
        	pointer.next = new ListNode(digit);
        	pointer = pointer.next;
        	if (l1 != null) {
        		l1 = l1.next;
        	}
        	if (l2 != null) {
        		l2 = l2.next;
        	}
        }
        
        if (carry == 1) {
        	pointer.next = new ListNode(carry);
        }
        
       return res.next;
        
    }
}