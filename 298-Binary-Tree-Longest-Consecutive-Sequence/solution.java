/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	private int longest = 0;

	public int longestConsecutive(TreeNode root) {
		helper(root);
		return longest;
	}

	private int helper(TreeNode root) {
		if (root == null)
			return 0;

		int left = helper(root.left);
		int right = helper(root.right);

		int length = 1;
		if (root.left != null && root.left.val == root.val + 1) {
			length = Math.max(left + 1, length);
		}

		if (root.right != null && root.right.val == root.val + 1) {
			length = Math.max(right + 1, length);
		}
		longest = Math.max(length, longest);

		return length;
	}
}