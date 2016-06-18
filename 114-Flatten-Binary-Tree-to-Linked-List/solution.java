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

		TreeNode left = flattenHelper(root.left);
		left.right = root.right;
//		TreeNode right = flattenHelper(root.right);
		root.right = left;
		root.left = null;
		
		return left.right;
	}

	

}