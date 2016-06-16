/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
    	// shift the node till the end;
    	while (node.next != null) {
    		node.val = node.next.val;
    		if (node.next.next != null) {
    			node = node.next;
    		} else {
    			// delete the tail -> node.next.next
    			node.next = null;
    			return;
    		}
    	}
    }
}