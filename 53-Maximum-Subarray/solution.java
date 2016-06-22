public class Solution {
    public int maxSubArray(int[] nums) {
        int[] matrix = new int[nums.length];
        matrix[0] = nums[0];
        int result = matrix[0];
        // matrix[i] represents the maximum sum at point i
        // matrix[i] = max(matrix[i-1] + nums[i], nums[i])
        for (int i = 1; i < matrix.length; i++) {
        	matrix[i] = Math.max(matrix[i-1] + nums[i], nums[i]);
        	result = Math.max(matrix[i], result);
        }
        
        return result;
    }
}