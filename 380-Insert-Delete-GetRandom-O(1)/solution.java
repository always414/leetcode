import java.util.*;

public class RandomizedSet {

	List<Integer> list;
	Map<Integer, Integer> map;
	Random r;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		list = new ArrayList<>();
		map = new LinkedHashMap<>();
		r = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		} else {
			map.put(val, list.size());
			return list.add(val);
		}
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		
		Integer index = map.get(val);
		Collections.swap(list, index, list.size() - 1);
		map.put(list.get(index), index);
		list.remove(list.size() - 1);
		map.remove(val);

		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.isEmpty() ? 0 : list.get(r.nextInt(list.size()));
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */