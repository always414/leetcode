import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	private static TreeNode NULLNODE = new TreeNode(0);

	public int rob(TreeNode root) {
		List<Integer> array = new ArrayList<>();
		treeToArray(array, root);
		Integer[] res = new Integer[array.size()];
		array.toArray(res);
		for (int i = res.length - 1; i >= 0; i--) {
			int parent = (i - 1) / 2;
			if (parent > 0) {
				int grandParent = (parent - 1) / 2;
				res[grandParent] += res[i];
			}
			
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			if (left < res.length && right < res.length) {
				res[i] = Math.max(res[left] + res[right], res[i]);
			}
		}

		return res[0];
	}
	// recursion logic:
	// f(root) = max(f(root.l) + f(root.r), root.val + f(root.l.l) + f(root.l.r)
	// + f(root.r.l) + f(root.r.r))

	private void treeToArray(List<Integer> array, TreeNode root) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			int num = size * 2;
			while (size-- > 0) {
				TreeNode node = queue.poll();
				array.add(node.val);

				if (node.left != null) {
					queue.add(node.left);
				} else {
					queue.add(NULLNODE);
					num--;
				}

				if (node.right != null) {
					queue.add(node.right);
				} else {
					queue.add(NULLNODE);
					num--;
				}
			}
			if (num == 0) {
				break;
			}
		}
	}
}