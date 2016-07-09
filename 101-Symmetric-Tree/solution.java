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
        return root == null || symmetricHelper(root.left, root.right);
    }
    
    //recursion solution 
    private boolean symmetricHelper(TreeNode left, TreeNode right) {
    	if (left == null || right == null) {
    		return left == right;
    	}
    	
    	return left.val == right.val && symmetricHelper(left.right, right.left) && symmetricHelper(left.left, right.right);
    	
    }
}