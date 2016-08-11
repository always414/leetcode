import java.util.*;

/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
public class NestedIterator implements Iterator<Integer> {

	private Deque<Iterator<NestedInteger>> stack;
	private NestedInteger next;

	public NestedIterator(List<NestedInteger> nestedList) {
		stack = new ArrayDeque<>();
		if (nestedList != null)
			stack.push(nestedList.iterator());
		next = null;
	}

	@Override
	public Integer next() {
		//next 只return stack的值，如果调用自身会出问题。在hasnext处理好null的问题
		return next == null? null : next.getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			if (!stack.peek().hasNext()) {
				stack.pop();
			} else if ((next = stack.peek().next()).isInteger()){ 
				return true;
			} else {
				stack.push(next.getList().iterator());
			}
		}
		return !stack.isEmpty();
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */