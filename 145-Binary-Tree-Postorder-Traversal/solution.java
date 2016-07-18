import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
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
	List<Integer> res;
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
        	if (root != null) {
        		stack.push(root);
        		//先push parent
        		res.add(root.val);
        		//遍历右边
        		root = root.right;
        	} else {
        		//返回上一层便利左边
        		root = stack.pop().left;
        	}
        	
        }

        //中右左的顺序，reverse后 左右中。
        //本质上，reverse preorder
        Collections.reverse(res);
        return res;
    }
    
   

}