/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
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