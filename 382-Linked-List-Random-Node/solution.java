import java.util.Random;

public class Solution {
	private ListNode head;
	private Random randomGenerator;
    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        randomGenerator = new Random();
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode result = null;
        ListNode current = head;
        for (int n = 1; current != null; n++) {
        	if (randomGenerator.nextInt(n) == 0) {
        		result = current;
        		//first round, nextInt always == 0
        		//no break, because have to traverse all n nodes and each node has 1/n probility
        	}
        	current = current.next;
        }
    	return result.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */