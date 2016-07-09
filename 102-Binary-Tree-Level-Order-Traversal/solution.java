import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        
        Queue<TreeNode> level = new ArrayDeque<>();
        level.offer(root);
        
        while (!level.isEmpty()) {
        	TreeNode node = level.poll();
        	if (node != null) {
        		level.offer(node.left);
        		level.offer(node.right);
        		subList.add(node.val);
        	} else {
        		res.add(new ArrayList<>(subList));
        		subList.clear();
        		if (level.isEmpty()) {
        			break;
        		} else {
        			level.add(null);
        		}
        	}
        }
        
        return res;
        
    }
}