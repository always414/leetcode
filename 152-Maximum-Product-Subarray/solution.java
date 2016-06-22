public class Solution {
    public int maxProduct(int[] nums) {
    	if (nums.length == 0) return 0;
    	if (nums.length == 1) return nums[0];
    	
    	int positive;
    	int negative;
    	int result = positive = negative = nums[0];
    	
        for (int i = 1; i < nums.length; i++) {
        	
        	int negativePre = negative, positivePre = positive;
        	
        	negative = Math.min(nums[i], Math.min(negativePre * nums[i], positivePre * nums[i]));
        	positive = Math.max(nums[i], Math.max(negativePre * nums[i], positivePre * nums[i]));

        	result= Math.max(result, positive);
        }
        return result;
        
    }
}