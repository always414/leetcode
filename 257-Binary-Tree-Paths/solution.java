import java.util.ArrayList;
import java.util.Iterator;
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
	List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        dfsHelper(new ArrayList<TreeNode>(), root);
        return res;
    }
    
    private void dfsHelper(List<TreeNode> path, TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	path.add(root);
    	if (root.left == null && root.right == null ) {
    		buildPath(path); // end position.
    	} else {
    		// go both branch
    		dfsHelper(path, root.left); 
    		dfsHelper(path, root.right);
    	}
    	path.remove(root); // backtrack
    }

	private void buildPath(List<TreeNode> path) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < path.size(); i++) {
			sb.append(path.get(i).val);
			sb.append("->");
		}
		
		sb.delete(sb.length() - 2, sb.length());
		res.add(sb.toString());
	}
}