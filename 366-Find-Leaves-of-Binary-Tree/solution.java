import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

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
    public List<List<Integer>> findLeaves(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<>();
    	Set<TreeNode> newLeaves = new HashSet<>();
    	Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    	buildMap(newLeaves, parentMap, root, null);
    	
    	while (!newLeaves.isEmpty()) {
    		List<TreeNode> toRemove = new ArrayList<>(newLeaves);
    		List<Integer> toAddRes = new ArrayList<>();
    		newLeaves.clear();
    		Iterator<TreeNode> it = toRemove.iterator();
    		while (it.hasNext()) {
    			
    			TreeNode leaf = it.next();
    			toAddRes.add(leaf.val);
    			it.remove();
    			
    			TreeNode parent = parentMap.remove(leaf);

    			if (parent == null) continue; 

    			if (leaf.equals(parent.left)) {
    				parent.left = null;
    			}
    			if (leaf.equals(parent.right)) {
    				parent.right = null;
    			}
    			if (parent.left == null && parent.right == null ) {
    				newLeaves.add(parent);
    			}
    		}
    		
    		res.add(toAddRes);
    	}
    		return res;
    }
    
    private void buildMap(Set<TreeNode> leaves, Map<TreeNode, TreeNode> map, TreeNode node, TreeNode parentNode) {
    	if (node == null) return;
    	
    	if (node.left == null && node.right == null) {
    		leaves.add(node);
    	} 
    	
    	if (parentNode != null)
    		map.put(node, parentNode);
    	
    	buildMap(leaves, map, node.left, node);
    	buildMap(leaves, map, node.right, node);
    }
}