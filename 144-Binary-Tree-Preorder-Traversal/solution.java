import java.util.ArrayList;
import java.util.List;

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
	
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
        preOrderHelper(root, res);
        return res;
    }
    
    private void preOrderHelper(TreeNode root, List<Integer> list) {
    	if (root == null) return;
    	list.add(root.val);
    	preOrderHelper(root.left, list);
    	preOrderHelper(root.right, list);
    }
}