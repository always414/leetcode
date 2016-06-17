public class Solution {
    public int[] twoSum(int[] nums, int target) {
       //three approaches
    	// Brute force o(n2) time O(1) space
    	for (int i = 0; i < nums.length - 1 ; i++) {
    		for (int j = i+1; j < nums.length; j++) {
    			if (nums[i] + nums[j] == target) {
    				return new int[] {i, j};
    			}
    		}
    	}
    	
    	throw new IllegalArgumentException("no two sum solution") ;
    	
    }
}