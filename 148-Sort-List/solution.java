/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Solution {
	public ListNode sortList(ListNode head) {
		// base case 1: 0~1 node
		if (head == null || head.next == null) {
			return head;
		}
		// base case 2: 2 nodes
		if (head.next.next == null) {
			if (head.val <= head.next.val) {
				return head;
			} else {
				ListNode res = head.next;
				res.next = head;
				head.next = null;
				return res;
			}
		}
		
		// case 3: more than 2 nodes
		ListNode left = head;
		ListNode middle = findMiddle(head);
		ListNode right = middle.next;
		middle.next = null;

		left = sortList(left);
		right = sortList(right);

		head = merge(left, right);

		return head;
	}

	private ListNode findMiddle(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null) {
			if (fast.next == null || fast.next.next == null) {
				return slow;
			} else {
				fast = fast.next.next;
				slow = slow.next;
			}
		}

		return slow;
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode pointer = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				pointer.next = l1;
				pointer = pointer.next;
				l1 = l1.next;
			} else {
				pointer.next = l2;
				pointer = pointer.next;
				l2 = l2.next;
			}
		}

		if (l1 != null) {
			pointer.next = l1;
		}

		if (l2 != null) {
			pointer.next = l2;
		}

		return dummy.next;
	}
}