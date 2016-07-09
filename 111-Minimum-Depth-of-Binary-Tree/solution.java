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
        		if (root.left == null && root.right == null) return depth + 1;
        		
        		queue.add(root.left);
        		queue.add(root.right);
        	}
        }
        
        return depth;
    	
    }
}