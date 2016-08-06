import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {
	// queue v1, v2
	// add and pop

	Queue<Iterator<Integer>> zigzagIterator;
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		zigzagIterator = new ArrayDeque<>();
		
		if (v1 != null && !v1.isEmpty()) {
			zigzagIterator.add(v1.iterator());
		}
		
		if (v2 != null && !v2.isEmpty()) {
			zigzagIterator.add(v2.iterator());
		}
	}

	public int next() {
		Iterator<Integer> nextIterator = zigzagIterator.poll();
		Integer res = nextIterator.next();
		if (nextIterator.hasNext()) {
			zigzagIterator.add(nextIterator);
		}
		return res;
	}

	public boolean hasNext() {
		return !zigzagIterator.isEmpty();
	}
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2); while (i.hasNext()) v[f()] =
 * i.next();
 */