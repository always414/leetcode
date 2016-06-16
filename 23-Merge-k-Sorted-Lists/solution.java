import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    	// utilize heap to store the smallest node, and merge
    	// constant space (length of lists) and O(logN) time for every insert;
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val) {
					return -1;
				} else if (o1.val == o2.val) {
					return 0;
				} else {
					return 1;
				}
			}
        });
        
        for (ListNode list : lists) {
        	queue.add(list);
        }
        
        while (!queue.isEmpty()) {
        	pointer.next = queue.poll();
        	pointer = pointer.next;
        	if (pointer.next != null) {
        		queue.add(pointer.next);
        	}
        }

        return dummy.next;

    }
}