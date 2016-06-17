import java.util.HashMap;

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
    	
    	// two way hashmap solution O(n) time O(n) space
    	HashMap<Integer, Integer> map = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
    		map.put(nums[i], i);
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
    		int complement = target - nums[i];
    		if (map.containsKey(complement) && map.get(complement) != i) {
    			return new int[] {map.get(complement), i};
    		}
    	}
    	
    	throw new IllegalArgumentException("no two sum solution") ;
    	
    	
    	
    }
}