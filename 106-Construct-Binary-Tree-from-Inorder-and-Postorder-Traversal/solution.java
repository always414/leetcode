import javax.swing.text.Position;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// inorder ... left root right ...
		// postorder left... right... root
		
		TreeNode root = buildHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);

		return root;
	}

	private TreeNode buildHelper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postorderStart,
			int postorderEnd) {
		
		if (inorderStart == inorderEnd && postorderStart == postorderEnd) {
			return new TreeNode(inorder[inorderStart]);
		} else if (inorderStart > inorderEnd && postorderStart > postorderEnd) {
			return null;
		}
		
		int inorderRoot = postorderEnd;
		while (inorderRoot >= 0 && inorder[inorderRoot] != postorder[postorderEnd]) {
			inorderRoot --;
		}
		
		TreeNode root = new TreeNode(inorder[inorderRoot]);
		root.left = buildHelper(inorder, postorder, inorderStart, inorderRoot - 1, inorderStart, inorderRoot - 1);
		root.right = buildHelper(inorder, postorder, inorderRoot + 1, inorderEnd, inorderRoot, postorderEnd - 1);
		
		return root;
		
	}
}