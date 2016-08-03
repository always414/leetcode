/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	private int max = 0;

	public int largestBSTSubtree(TreeNode root) {

		largestBSTSubtree(root.left, root.val, Long.MIN_VALUE);
		largestBSTSubtree(root.right, Long.MAX_VALUE, root.val);

		return max;
	}

	private int largestBSTSubtree(TreeNode root, long upperbound, long lowerbound) {
		if (root == null)
			return 0;

		if (root.val <= lowerbound || root.val >= upperbound) {
			return -1;
		}

		int left = largestBSTSubtree(root.left, root.val, lowerbound);
		int right = largestBSTSubtree(root.right, upperbound, root.val);

		if (left == -1 || right == -1) {
			return -1;
		}

		max = Math.max(left + right + 1, max);
		return left + right + 1;

	}
}