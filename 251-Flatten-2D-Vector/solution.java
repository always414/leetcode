import java.util.*;

public class Vector2D implements Iterator<Integer> {
	private Iterator<List<Integer>> itr;
	private Iterator<Integer> subItr;

	public Vector2D(List<List<Integer>> vec2d) {
		itr = (vec2d == null || vec2d.isEmpty()) ? null : vec2d.iterator();
		subItr = null;
	}

	@Override
	public Integer next() {
		return subItr.next();
	}

	@Override
	public boolean hasNext() {
		// 在hasnext里处理好null
		if (itr == null) {
			return false;
		}

		if (subItr != null && subItr.hasNext()) {
			return true;
		}

		while (itr.hasNext()) {
			List<Integer> subList = itr.next();
			if (!subList.isEmpty()) {
				subItr = subList.iterator();
				break;
			}
		}
		return subItr != null && subItr.hasNext();
	}
}

/**
 * Your Vector2D object will be instantiated and called as such: Vector2D i =
 * new Vector2D(vec2d); while (i.hasNext()) v[f()] = i.next();
 */