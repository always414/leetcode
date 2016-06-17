/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
        ListNode odd = head;
        ListNode even = head.next, evenHead = head.next;
        
        ListNode curr = head.next.next;
        
        // 1 -> 2 -> 3 -> 4 -> 5;
        while (curr != null) {
        	odd.next = curr; 
        	even.next = curr.next;
        	// 1 -> 3 -> 4 -> 5;  2 -> 4 -> 5
        	odd = odd.next;
        	even = even.next;
        	// 3->4->5; 4->5
        	
        	if (even == null) {
        		break;
        	}
        	// 5(curr)
        	curr = even.next;
        }
        
        odd.next = evenHead;
        
        return head;
    }
}