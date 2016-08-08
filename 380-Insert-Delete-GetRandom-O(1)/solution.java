import java.util.*;

public class RandomizedSet {

	List<Integer> cur;
	Set<Integer> set;
	Random r;
    /** Initialize your data structure here. */
    public RandomizedSet() {
    	cur = new ArrayList<>();
    	set = new LinkedHashSet<>();
    	r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return set.add(val) && cur.add(val);
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	Integer o = val;
        return set.remove(o) && cur.remove(o);
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return cur.isEmpty()? 0 : cur.get(r.nextInt(cur.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */