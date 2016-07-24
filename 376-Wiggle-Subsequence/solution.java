public class Solution {
    public int wiggleMaxLength(int[] nums) {
    	if (nums.length < 2) return nums.length;

    	int count = 1;
    	boolean increasing = nums[1] > nums[0];
    	int prev = nums[0];
    	
    	for (int i= 1; i < nums.length; i++) {
    		if (increasing) {
    			if (nums[i] > prev) {
    				increasing = !increasing;
    				count ++;
    			}
    		} else {
    			if (nums[i] < prev) {
    				increasing = !increasing;
    				count ++;
    			}
    		}
    		prev = nums[i];
    	}
    	
//       System.out.println(Arrays.toString(diff));
    	return count;
    }
}