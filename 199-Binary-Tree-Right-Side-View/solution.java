import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
        	return null;
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while (! queue.isEmpty()) {
        	int size = queue.size();
        	while (size > 0) {
        		if (queue.peek().left != null) {
        			queue.offer(queue.peek().left);
        		}
        		if (queue.peek().right != null) {
        			queue.offer(queue.peek().right);
        		}
        		
        		if (size == 1) {
        			res.add(queue.poll().val);
        		} else {
        			queue.poll();
        		}
        	}
        	
        }
        return res;
    	
    }
}