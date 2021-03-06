import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
	
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	Deque<TreeNode> stack = new ArrayDeque<>();
    	if (root == null) return res;
    	
    	stack.push(root);
    	
    	while (!stack.isEmpty()) {
    		TreeNode node = stack.pop();
    		res.add(node.val);
    		
    		if (node.right != null)
    			stack.push(node.right);
    		if (node.left != null)
    			stack.push(node.left);
    	}
    	return res;
    }
    
}