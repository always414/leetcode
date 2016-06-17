/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
    	if (head == null || head.next == null) {
    		return;
    	}
        ListNode middle = findMiddle(head);
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;
        
        right = reverse(right);
        
        while (right != null) {
        	ListNode toInsert = right;
        	right = right.next;
        	toInsert.next = left.next;
        	left.next = toInsert;
        	left = left.next.next;
        }
    	
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
    
    private ListNode reverse (ListNode head) {
    	if (head == null || head.next == null) {
        	return head;
        }
        
        ListNode res = null;
        while (head != null) {
        	ListNode newHead = head.next;
        	head.next = res;
        	res = head;
        	head = newHead;
        }
        
        return res;
    }
    
}