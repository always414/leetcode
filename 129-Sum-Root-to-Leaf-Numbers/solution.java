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
	int sum = 0;
    public int sumNumbers(TreeNode root) {
        // dfs , traverse all the possible number from root to leaf, sum up
    	dfsHelper(root, 0);
    	return sum;
    }
    
    public void dfsHelper(TreeNode root, int num) {
    	if (root == null) {
    		return;
    	} 
    	if (root.left == null && root.right == null) {
    		num = num * 10 + root.val;
    		sum += num;
    		return;
    	}
    	dfsHelper(root.left, num*10 + root.val);
    	dfsHelper(root.right, num*10 + root.val);
    }
}