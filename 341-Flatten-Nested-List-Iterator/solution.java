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
		Iterator<NestedInteger> itr = stack.poll();
		next = itr.next();

		if (next.isInteger()) {
			stack.push(itr);
			return next.getInteger();
		} else {
			stack.push(itr);
			stack.push(next.getList().iterator());
			return next();
		}

	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty() && !stack.peek().hasNext()) {
			stack.poll();
		}
		return !stack.isEmpty();
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */