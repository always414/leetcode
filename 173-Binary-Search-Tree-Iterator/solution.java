import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	TreeNode node;
	Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.node = root;
        stack = new ArrayDeque<>();
        while (node != null) {
        	stack.push(node);
        	node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode next = stack.pop();
    	int value = next.val;
    	next = next.right;
    	if (next != null) {
    		stack.push(next);
    		next = next.left;
    	}
    	while (next != null) {
    		stack.push(next);
    		next = next.left;
    	}
    	
        return value;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */