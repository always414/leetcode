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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        if (root.left.val >= root.val || root.right.val <= root.val) return false;
        
        return max(root.left) < root.val && min(root.right) > root.val && isValidBST(root.left) && isValidBST(root.right);
    }
    
    private int max (TreeNode root) {
    	if (root == null) return Integer.MIN_VALUE;
    			
    	while (root.right != null) {
    		root = root.right;
    	}
    	
    	return root.val;
    }
    
    private int min(TreeNode root) {
    	if (root == null) return Integer.MAX_VALUE;
    	while (root.left != null) {
    		root = root.left;
    	}
    	return root.val;
    }
}