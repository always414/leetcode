public class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
        	if (nums[start] < nums[end]) {
        		return nums[start];
        	}
        	
        	int mid = start + (end - start) /2;
        	
        	if (nums[mid] > nums[end]) {
        		start = mid;
        	} else if (nums[mid] < nums[start]) {
        		end = mid;
        	}
        }
        
        return Math.min(nums[start], nums[end]);
    	
    }
    
    
}