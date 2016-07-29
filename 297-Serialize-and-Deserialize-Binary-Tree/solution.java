import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
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
public class Codec {
	
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //use bfs to construct a string
    	StringBuilder data = new StringBuilder();
    	if (root == null) return data.toString();
    	
    	Queue<TreeNode> queue = new ArrayDeque<>();
    	queue.add(root);
    	StringBuilder currentLevel = new StringBuilder();
    	currentLevel.append(root.val + ",");
    	while (!queue.isEmpty() && currentLevel.length() > 0) {
    		StringBuilder nextLevel = new StringBuilder();
    		String[] nodes = currentLevel.toString().split(",");
    		for (int i = 0; i < nodes.length; i++) {
    			if (nodes[i].equals("null")) {
    				nextLevel.append("null,null,");
    			} else {
    				TreeNode node = queue.poll();
    				if (node.left != null) {
    					queue.offer(node.left);
    					nextLevel.append(node.left.val + ",");
    				} else {
    					nextLevel.append("null,");
    				}
    				
    				if (node.right != null) {
    					queue.offer(node.right);
    					nextLevel.append(node.right.val + ",");
    				} else {
    					nextLevel.append("null,");
    				}
    			}
    		}
    		data.append(currentLevel.toString());
    		currentLevel = nextLevel;
    	}
    	return data.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if (data == null || data.length() == 0 || !data.contains(",")) {
    		return null;
    	}
    	String[] array = data.split(",");
    	TreeNode[] serial = new TreeNode[array.length];
    	serial[0] = generateNode(array, serial, 0);
    	for (int i = 0; i < array.length; i++) {
    		if (serial[i] == null) continue;
    		serial[i].left = generateNode(array,serial, 2*i + 1);
    		serial[i].right = generateNode(array,serial, 2 * i + 2);
    	}
    	return serial[0];
    }
    
    private TreeNode generateNode(String[] array, TreeNode[] serial, int index) {
    	if (index > array.length - 1 || array[index].equals("null")) {
    		return null;
    	} else if (serial[index] != null) {
    		return serial[index];
    	} else {
    		serial[index] = new TreeNode(Integer.parseInt(array[index]));
    		return serial[index];
    	}
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));