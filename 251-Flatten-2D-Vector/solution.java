import java.util.*;

public class Vector2D implements Iterator<Integer> {
	private Iterator<List<Integer>> itr;
	private Iterator<Integer> subItr;
    public Vector2D(List<List<Integer>> vec2d) {
        itr = (vec2d == null)? null : vec2d.iterator();
        subItr = (itr == null)? null : itr.next().iterator();
    }

    @Override
    public Integer next() {
        return subItr.next();
    }

    @Override
    public boolean hasNext() {
    	if (subItr == null) return false;
        while (!subItr.hasNext() && itr.hasNext()) {
        	subItr = itr.next().iterator();
        }
        return subItr.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */