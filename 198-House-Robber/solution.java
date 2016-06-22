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
    	
    	int[] matrix = new int[nums.length];
    	matrix[0] = nums[0];
    	matrix[1] = Math.max(nums[0], nums[1]);
    	for (int i = 2; i < nums.length; i++) {
    		matrix[i] = Math.max(matrix[i-1], matrix[i-2] + nums[i]); // max rob i or not
    	}
        
        return matrix[matrix.length - 1];
    	
    }
}