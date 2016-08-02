import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {
	private static String NULL = "null";
	private static String DELIMITER = ",";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	private void buildString(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append(NULL).append(DELIMITER);
		} else {
			sb.append(root.val).append(DELIMITER);
			buildString(root.left, sb);
			buildString(root.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0 || !data.contains(","))
			return null;
		Deque<String> nodes = new ArrayDeque<>();
		nodes.addAll(Arrays.asList(data.split(DELIMITER)));

		return buildTree(nodes);
	}
	
	private TreeNode buildTree(Deque<String> nodes) {
		String val = nodes.remove();
		if (val.equals(NULL)) return null;
		else {
			TreeNode node = new TreeNode(Integer.parseInt(val));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}
	}

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));