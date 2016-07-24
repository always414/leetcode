import java.util.Arrays;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
    	if (nums.length < 2) return nums.length;

    	int[] diff = new int[nums.length];
    	diff[1] = nums[1] == nums[0]? 0 : nums[1] - nums[0] > 0? 1 : -1;
    	diff[0] = 0 - diff[1];

    	int count = 1;
    	
    	for (int i = 1; i < nums.length; i++) {
    		diff[i] = nums[i] == nums[i-1] ? 0 : nums[i] - nums[i-1] > 0 ? 1 : -1;
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