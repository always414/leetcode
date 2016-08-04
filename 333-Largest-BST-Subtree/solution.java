/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	int res = 0;
	public int largestBSTSubtree(TreeNode root) {
		dfs(root);
		return res;
	}

     /**
      * dfs search each node from root to leaf, and if find the largest subtree, end recursion.
      * @param root
      */
	private void dfs(TreeNode root) {
		if (root == null)
			return;
		int d = largestBSTSubtree(root, Long.MAX_VALUE, Long.MIN_VALUE);

		if (d != -1) {
			res = Math.max(d, res);
			return;
		}

		dfs(root.left);
		dfs(root.right);
	}

	/**
	 * Returns the largestBSTTree of root and update global max value
	 * 
	 * @param root
	 * @param upperbound
	 * @param lowerbound
	 * @return -1 if root is not in valid range, or subtree of root is not valid
	 *         BST; 0 if root is null; tree size of root if it's a valid bst
	 */
	private int largestBSTSubtree(TreeNode root, long upperbound, long lowerbound) {
		if (root == null)
			return 0;
		if (root.val < lowerbound || root.val > upperbound) {
			return -1;
		}

		int left = largestBSTSubtree(root.left, root.val, lowerbound);
		if (left == -1)
			return -1;

		int right = largestBSTSubtree(root.right, upperbound, root.val);
		if (right == -1)
			return -1;

		return left + right + 1;
	}
}