import java.util.ArrayDeque;
import java.util.Deque;

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
    public int kthSmallest(TreeNode root, int k) {
        //inorde traversal, sorted by value.
    	Deque<TreeNode> stack = new ArrayDeque<>();
    	while (!stack.isEmpty() || root != null) {
    		if (root != null) {
    			stack.push(root);
    			root = root.left;
    		} else {
    			root = stack.pop();
    			k --;
    			if (k == 0) return root.val;
    			root = root.right;
    		}
    	}
    	return 0;
    }
}