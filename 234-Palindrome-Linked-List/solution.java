/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        // reverse half list and compare
    	// O(cn) time and O(1) space
    	if (head == null || head.next == null) {
    		return true;
    	}
    	ListNode middle = findMiddle(head);
    	
    	ListNode left = head;
    	ListNode right = middle.next;
    	middle.next = null; // break the list into halves
    	right = reverse(right);
    	
    	while (left != null) {
    		if (left.val != right.val) {
    			return false;
    		} 
    	}
    	
    	return true;
    }
    
    private ListNode reverse(ListNode head) {
    	ListNode res = null;
    	while (head != null) {
    		ListNode next = head.next;
    		head.next = res;
    		res = head;
    		head = next;
    	}
    	return res;
    }
    
    private ListNode findMiddle (ListNode head) {
    	ListNode fast = head, slow = head;
    	while (fast != null) {
    		if (fast.next != null && fast.next.next != null) {
    			fast = fast.next.next;
    			slow = slow.next;
    		} else {
    			break;
    		}
    	}
    	
    	return slow;
    }
}