import java.util.HashMap;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        while (head != null) {
        	if (! map.containsKey(head)) {
        		map.put(head, new RandomListNode(head.label));
        	}
        	
        	if (head.random != null && !map.containsKey(head.random)) {
        		map.put(head.random, new RandomListNode(head.random.label));
        	}
        	
        	pre.next = map.get(head);
        	pre.next.random = map.get(head.random);

        	head = head.next;
        	pre = pre.next;
        }
        return dummy.next;
    }
    
    
}