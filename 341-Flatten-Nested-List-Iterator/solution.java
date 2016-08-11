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

	Deque<Iterator<NestedInteger>> stack;
	NestedInteger next;

	public NestedIterator(List<NestedInteger> nestedList) {
		stack = new ArrayDeque<>();
		Iterator<NestedInteger> itr = nestedList.iterator();
		if (itr.hasNext()) {
			next = itr.next();
		} else {
			next = null;
		}
		if (itr.hasNext()) {
			stack.push(itr);
		}
	}

	@Override
	public Integer next() {
		Integer val;
		if (next.isInteger()) {
			val = next.getInteger();

			if (stack.isEmpty()) {
				next = null;
			} else {
				Iterator<NestedInteger> itr = stack.pop();
				next = itr.next();
				if (itr.hasNext()) {
					stack.push(itr);
				}
			}

			return val;
		} else {
			Iterator<NestedInteger> itr = next.getList().iterator();
			next = itr.next();
			stack.push(itr);
			return next();
		}
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */