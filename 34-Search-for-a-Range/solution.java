import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
    	if (nums.length == 0) {
    		return new int[] {-1, -1};
    	}
        int[] res = new int[2];
        int start = 0, end = nums.length - 1;
        
        while (start + 1 < end) {
        	int mid = start + (end - start) /2;
        	if (nums[mid] == target) { // find left start 
        		end = mid;
        	} else if (nums[mid] < target) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }
        
        res[0] = nums[start] == target? start : nums[end] == target? end : -1;
        
        start = 0;
        end = nums.length -1;
        while (start + 1 < end) {
        	int mid = start + (end - start) / 2;
        	if (nums[mid] == target ){
        		start = mid; // find right end
        	} else if (nums[mid] < target ) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }
        
        res[1] = nums[end] == target? end : nums[start] == target? start : -1;
        return res;
    }
    
}