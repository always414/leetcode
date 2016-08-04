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
	class Result {
		int size;
		int max;
		int min;
		public Result(int size, int min, int max) {
			this.size = size;
			this.max = max;
			this.min = min;
		}
	}
	
	
    public int largestBSTSubtree(TreeNode root) {
    	Result res = BSTSubtree(root);
    	return Math.abs(res.size);
    	
    }
    
    private Result BSTSubtree(TreeNode root) {
    	if (root == null) return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    	Result left = BSTSubtree(root.left);
    	Result right = BSTSubtree(root.right);
    	
    	if (left.size < 0 || right.size < 0 || root.val < left.max || root.val > right.min) {
    		return new Result(Math.max(Math.abs(left.size), Math.abs(right.size)) * (-1), 0, 0);
    	} else {
    		return new Result(left.size + right.size + 1, Math.min(root.val, left.min), Math.max(root.val, right.max));
    	}
    	
    }
    
   

}