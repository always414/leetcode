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
        Queue<TreeNode> level = new ArrayDeque<>();
        
        level.offer(root);
        
        while (!level.isEmpty()) {
        	int size = level.size();
        	List<Integer> subList = new ArrayList<>();

        	while (size > 0) {
        		TreeNode node = level.poll();
        		subList.add(node.val);
        		if (node.left != null) {
        			level.add(node.left);
        		}
        		
        		if (node.right != null) {
        			level.add(node.right);
        		}
        		
        		size --;
        	}
        	
        	res.add(subList);
        }
        
        return res;
        
    }
}