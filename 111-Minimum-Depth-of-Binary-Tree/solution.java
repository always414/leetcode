import java.util.ArrayDeque;
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
    public int minDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	depth ++;
        	
        	while (size > 0) {
        		TreeNode node = queue.poll();
        		if (node.left == null && node.right == null) return depth;
        		if (node.left != null)
        			queue.add(node.left);	
        		if (node.right != null)
        			queue.add(node.right);
        		size --;
        	}
        }
        
        return depth;
    	
    }
}