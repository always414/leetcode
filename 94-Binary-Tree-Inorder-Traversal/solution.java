import java.util.ArrayList;
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
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        inorderHelper(root);
        
        return res;
        
    }
    
    private void inorderHelper (TreeNode root) {
    	if (root == null) return;
    	inorderHelper(root.left);
    	res.add(root.val);
    	inorderHelper(root.right);
    	
    }
}