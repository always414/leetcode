import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

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
public class Solution {
	public int depthSumInverse(List<NestedInteger> nestedList) {
		// dfs, stack

		List<Integer> sumDepth = new ArrayList<Integer>();
		sumDepth.add(0);

		dfsHelper(nestedList, sumDepth, 1);

		Collections.reverse(sumDepth);
		sumDepth.add(0, 0);
		int res = 0;
		for (int i = 0; i < sumDepth.size(); i++) {
			res += i * sumDepth.get(i);
		}

		return res;

	}

	private void dfsHelper(List<NestedInteger> nestedList, List<Integer> sumDepth, int depth) {
		nestedList.forEach(nest -> {
			if (nest.isInteger()) {
				insertInteger(sumDepth, depth, nest.getInteger());
			} else {
				Integer integer = nest.getInteger();
				List<NestedInteger> nestList = nest.getList();
				
				if (integer != null) {
					insertInteger(sumDepth, depth, integer);
				}
				
				if (nestList != null) {
					dfsHelper(nestedList, sumDepth, depth + 1);
				}
			}
		});
	}

	private void insertInteger(List<Integer> sumDepth, int depth, int integer) {
		while (depth >= sumDepth.size()) {
			sumDepth.add(0);
		}
		sumDepth.set(depth, sumDepth.get(depth) + integer);
	}
}