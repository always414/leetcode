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
	
    public List<TreeNode> generateTrees(int n) {
    	if (n == 0) {
    		return new ArrayList<TreeNode>();
    	}
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees (int start, int end) {
    	List<TreeNode> res = new ArrayList<>();

    	if (start > end) {
    		res.add(null);
    		return res;
    	}
    	
    	for (int rootValue = start; rootValue <= end; rootValue++) {
    		List<TreeNode> left = generateTrees(start, rootValue - 1);
        	List<TreeNode> right = generateTrees(rootValue + 1, end);
        	for (TreeNode leftChild: left) {
        		for (TreeNode rightChild: right) {
        			TreeNode root = new TreeNode(rootValue);
        			root.left = leftChild;
        			root.right = rightChild;
        			res.add(root);
        		}
        	}
    	}
    	
    	return res;
    }
}