import java.util.Arrays;

public class Solution {
    public void wiggleSort(int[] nums) {
    	if (nums == null) return;
    	
    	for (int i = 1; i<nums.length; i++) {
    		int a = nums[i-1];
    		if ( (i%2 == 1) == (a > nums[i])) {
    		    //the if condition is beautiful
    		    // swap nums[i] and nums[i-1] 
    		    //if and only if
    		    //1. i % 2 == 1 && nums[i-1] > nums[i]
    		    //2. i % 2 == 0 && nums[i-1] <= nums[i]
    			nums[i-1] = nums[i];
    			nums[i] = a;
    		}
    		
    	}
      return;
       
    }

}
