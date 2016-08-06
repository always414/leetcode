import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {
	// queue v1, v2
	// add and pop

	Queue<Iterator<Integer>> zigzagIterator;
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		zigzagIterator = new ArrayDeque<>();
		zigzagIterator.add(v1.iterator());
		zigzagIterator.add(v2.iterator());
	}

	public int next() {
		Iterator<Integer> nextIterator = zigzagIterator.poll();
		if (nextIterator.hasNext()) {
			zigzagIterator.offer(nextIterator);
			return nextIterator.next();
		} else {
			return next();
		}
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