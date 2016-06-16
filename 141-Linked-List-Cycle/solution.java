/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while (true) {
        	if (fast.next == null || fast.next.next == null) {
        		return false;
        	} else {
        		fast = fast.next.next;
        		slow = slow.next;
        		
        		if (fast == slow) {
        			return true;
        		}
        	}
        }
    }
}