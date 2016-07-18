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
	List<Integer> res;
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) return res;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while (!stack.isEmpty()) {
        	TreeNode node = stack.peekFirst();
        	if (node.left == null && node.right == null) {
        		res.add(node.val);
        		stack.pop();
        	}
        	if (node.right != null){
        		stack.push(node.right);
        		node.right = null;
        	}
        	if (node.left != null) {
        		stack.push(node.left);
        		node.left = null;
        	}
        }
        

        return res;
    }
    
   

}