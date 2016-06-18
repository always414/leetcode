/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public void flatten(TreeNode root) {
		flattenHelper(root);
	}

	public TreeNode flattenHelper(TreeNode root) {
		if (root.left == null && root.right == null)
			return root;

		if (root.left == null && root.right != null) {
			return root.right;
		}
		
		if (root.left != null && root.right == null) {
			root.right = root.left;
			root.left = null;
			return root.right;
		}
		
		TreeNode left = flattenHelper(root.left);
		left.right = root.right;
		root.right = root.left;
		root.left = null;
		TreeNode end = flattenHelper(left.right);
		
		return end;
	}

	

}