import java.util.ArrayDeque;
import java.util.ArrayList;
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
    public boolean isSymmetric(TreeNode root) {
    	//iterative solution
    	
    	Queue<TreeNode> queue = new ArrayDeque<>();
    	if (root == null) return true;
    	
    	queue.add(root.left);
    	queue.add(root.right);
    	
    	while (queue.size() > 1 ) {
    		TreeNode left = queue.poll(),
    				right = queue.poll();
    		if (left == null || right == null) {
    			return left == right;
    		}
    		
    		if (left.val != right.val ) {
    			return false;
    		}
    		
    		queue.add(left.left);
    		queue.add(right.right);
    		queue.add(left.right);
    		queue.add(right.left);
    	}
    	
    	return true;
    	
//        return root == null || symmetricHelper(root.left, root.right);
    }
    
    //recursion solution 
    private boolean symmetricHelper(TreeNode left, TreeNode right) {
    	if (left == null || right == null) {
    		return left == right;
    	}
    	
    	return left.val == right.val && symmetricHelper(left.right, right.left) && symmetricHelper(left.left, right.right);
    	
    }
}