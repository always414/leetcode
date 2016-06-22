public class Solution {
    public int rob(int[] nums) {
       // matrix[i] represents the maximum amount of money can rob at point i
    	// matrix[i] = nums[i] +  matrix[i-2]
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	
    	if (nums.length == 1) {
    		return nums[0];
    	}
    	
    	if (nums.length == 2) {
    		return Math.max(nums[0], nums[1]);
    	}
    	
    	if (nums.length == 3) {
    		return Math.max(nums[0] + nums[2], nums[1]);
    	}
    	
    	int[] matrix = new int[nums.length];
        matrix[0] = nums[0];
        matrix[1] = nums[1];
        matrix[2] = nums[0] + nums[2];
        
        for (int i = 3; i < nums.length; i++) {
        	matrix[i] = nums[i] + Math.max(matrix[i-2], matrix[i-3]);
        }
        
        return Math.max(matrix[matrix.length - 1], matrix[matrix.length - 2]);
    	
    }
}