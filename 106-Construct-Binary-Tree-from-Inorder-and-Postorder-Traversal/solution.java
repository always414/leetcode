import javax.swing.text.Position;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// inorder ... left ... root ... right ...
		// postorder ...left ...right root
		if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0) {
			return null;
		}

		TreeNode root = buildHelper(inorder, 0, inorder.length -1, postorder, postorder.length -1);
		return root;
	}

	private TreeNode buildHelper(int[] inorder, int start, int end, int[] postorder, int rootIndex) {
		if (start > end || rootIndex < 0 || rootIndex > postorder.length - 1) return null;
		if (start == end) return new TreeNode(inorder[start]);
		
		TreeNode root = new TreeNode(postorder[rootIndex]);
		
		int index = end;
		while (index > start && inorder[index] != root.val) {
			index --;
		}
		
		root.left = buildHelper(inorder, start, index - 1, postorder, rootIndex - end + index - 1);
		root.right = buildHelper(inorder, index + 1,  end, postorder, rootIndex - 1);
		
		return root;
	}
	
	
}