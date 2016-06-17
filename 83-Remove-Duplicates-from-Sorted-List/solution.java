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
    	
        ListNode curr = head.next;
        ListNode pre = head;
        
        while (curr != null) {
        	if (curr.val == pre.val) {
        		// 1(pre) -> 1(curr) -> 2
        		pre.next = curr.next;
        		curr = curr.next; // 1 (pre) -> 2(curr)
        		
        	} else {
        		// 1(pre) -> 2(curr) -> 3
        		pre = pre.next;
        		curr = curr.next; // 1 -> 2 (pre) -> 3(curr)
        	}
        }
        return head;
    }
}