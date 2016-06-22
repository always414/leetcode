public class Solution {
    public int maxProduct(int[] nums) {
    	if (nums.length == 0) return 0;
    	if (nums.length == 1) return nums[0];
    	
    	int[] positive = new int[nums.length];
    	int[] negative = new int[nums.length];
    	int result = positive[0] = negative[0] = nums[0];
    	
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] == 0) {
        		positive[i] = 0;
        		negative[i] = 0;
        		continue;
        	}
        	
        	negative[i] = Math.min(nums[i], Math.min(negative[i-1] * nums[i], positive[i-1] * nums[i]));
        	positive[i] = Math.max(nums[i], Math.max(negative[i-1] * nums[i], positive[i-1] * nums[i]));

        	result= Math.max(result, positive[i]);
        }
        return result;
        
    }
}