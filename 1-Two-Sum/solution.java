import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
       //three approaches
    	// Brute force o(n2) time O(1) space
    	/*for (int i = 0; i < nums.length - 1 ; i++) {
    		for (int j = i+1; j < nums.length; j++) {
    			if (nums[i] + nums[j] == target) {
    				return new int[] {i, j};
    			}
    		}
    	}*/
    	
    	Map<Integer, Integer> map = new HashMap<>();

    	// two way hashmap solution O(n) time O(n) space
    	/*for (int i = 0; i < nums.length; i++) {
    		map.put(nums[i], i);
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
    		int complement = target - nums[i];
    		// situation that i appear double times
    		if (map.containsKey(complement) && map.get(complement) != i) {
    			return new int[] {map.get(complement), i};
    		}
    	}*/
    	
    	//one way hashmap solution, o(n) time O(n) space
    	//brilliant
    	for (int i = 0; i < nums.length; i++) {
    		int complement = target - nums[i];
    		if (map.containsKey(complement)) {
    			return new int[] {map.get(complement), i};
    		}
    		map.put(nums[i], i);
    	}
    	
    	
    	throw new IllegalArgumentException("no two sum solution") ;
    	
    	
    	
    }
}