import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
        int[] length = new int[nums.length];
        int maxLength = 1;
        Arrays.fill(length, 1);
        
        for (int i = 1; i < nums.length; i++) {
        	for (int j = i-1; j >=0; j--) {
        		if (nums[j] < nums[i]) {
        			length[i] = Math.max(length[j] + 1, length[i]);
        			
        		}
        	}
        	maxLength = Math.max(maxLength, length[i]);
        }
        
        return maxLength;
    }
}