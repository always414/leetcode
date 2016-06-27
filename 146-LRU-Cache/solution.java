import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity) {
    	this.CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true) {
        	@Override
        	protected boolean removeEldestEntry(Map.Entry eldest) {
        		return size() > CAPACITY;
        	}
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void set(int key, int value) {
        map.put(key, value);
    }
}