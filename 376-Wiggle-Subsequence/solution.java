import java.util.Arrays;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
    	if (nums.length < 2) return nums.length;

    	int[] diff = new int[nums.length];
    	for (int i = 1; i < nums.length; i++) {
    		if (nums[i] - nums[i-1] == 0) {
    			diff[i] = 0;
    		} else if (nums[i] - nums[i-1] > 0) {
    			diff[i] = 1;
    		} else {
    			diff[i] = -1;
    		}
    	}
    	
    	diff[0] = 0 - diff[1];
    	
    	int count = 1;
    	for (int i = 1; i < nums.length; i++) {
    		int j = 1;
    		while ((i-j) > 0 && diff[i-j] == 0) {
    			j++;
    		}
    		if (diff[i] * diff[i-j] < 0) {
    			count ++;
    		} 
    	}
//       System.out.println(Arrays.toString(diff));
    	return count;
    }
}