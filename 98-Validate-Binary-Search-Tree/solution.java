/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {

	public boolean isValidBST(TreeNode root) {
		return isvalidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
	}

	private boolean isvalidBST(TreeNode root, long upperBound, long lowerBound) {
		if (root == null)
			return true;
		if (root.val >= upperBound || root.val <= lowerBound) {
			return false;
		}
		return isvalidBST(root.left, root.val, lowerBound) && isvalidBST(root.right, upperBound, root.val);
	}
}