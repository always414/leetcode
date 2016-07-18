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
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        postOrderHelper(root);
        return res;
    }
    
    private void postOrderHelper(TreeNode root) {
    	if (root == null) return;
    	postOrderHelper(root.left);
    	postOrderHelper(root.right);
    	res.add(root.val);
    }
}