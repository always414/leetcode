/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		if (k == 0 || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);

		ListNode fast = head, slow = head;
		int length = 0;
		while (k > 0) {
			fast = fast.next;
			length++;
			k--;
			if (fast == null) {
				// reach to the end, get the length, first mode k
				// then decide
				k %= length;
				if (k == 0) {
					return head;
				} else {
					fast = head;
				}
			}
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		dummy.next = slow.next;
		slow.next = null;
		fast.next = head;

		return dummy.next;

	}
}