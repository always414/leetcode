public class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
        	if (nums[start] < nums[end]) {
        		return nums[start];
        	}
        	//if there are duplicates
        	
        	//去重
        	while (start + 1 < end && nums[start] == nums[start + 1]) {
        		start ++;
        	}
        	
        	while (start + 1 < end && nums[end] == nums[end - 1]) {
        		end --;
        	}
        	
        	//如果左右两边相等，去尾
        	if (nums[start] == nums[end]) {
        		if (start + 1 == end) {
        			return Math.min(nums[start], nums[end]);
        		}
        		end -= 1;
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