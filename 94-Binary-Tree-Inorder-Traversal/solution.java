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
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	Deque<TreeNode> stack = new ArrayDeque<>();
    	while (!stack.isEmpty() || root != null) {
    		if (root != null) {
    			//push root and all left side
    			stack.push(root);
    			root = root.left;
    		} else {
    			//pop from the very left, each pop is a sub root node
    			//then traverse that node's right child.
    			root = stack.pop();
    			res.add(root.val);
    			root = root.right;
    		}
    		
    	}

        
        return res;
        
    }
}