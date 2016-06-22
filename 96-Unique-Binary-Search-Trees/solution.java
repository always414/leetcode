import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;

public class Solution {
	static HashMap<Integer, Integer> map = new HashMap<>();
	static {
		map.put(0, 1);
		map.put(1, 1);
		map.put(2, 2);
	}
    public int numTrees(int n) {
    	
    	if (map.containsKey(n)) {
    		return map.get(n);
    	}
    	
    	int total = 0;
    	for (int i = 0; i < n; i++) {
    		total += numTrees(i) * numTrees(n - 1 - i);
    	}
    	map.put(n, total);
    	
    	return total;
    }
}