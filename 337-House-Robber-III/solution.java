/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public int rob(TreeNode root) {
		dfs(root);
		return root == null? 0 : root.val;
	}

	private int dfs(TreeNode root) {
		if (root == null)
			return 0;
		int leftGrand = dfs(root.left);
		int rightGrand = dfs(root.right);
		
		int left = root.left == null ? 0 : root.left.val;
		int right = root.right == null ? 0 : root.right.val;
		root.val = Math.max(left + right, root.val + leftGrand + rightGrand);

		return left + right;
	}
}