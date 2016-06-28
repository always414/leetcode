import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
        	for (int j = nums.length - 1; j > i + 1; j -- ) {
        		for (int k = i + 1; k < j; k ++) {
        			if (nums[i] + nums[j] + nums[k] > 0) {
        				break;
        			} else if (nums[i] + nums[j] + nums[k] == 0) {
        				res.add(Arrays.asList(nums[i], nums[k], nums[j]));
        			}
        			
        			while (k < j - 1 && nums[k] == nums[k + 1]) {
        				k++;
        			}
        		}
        		while (j > i + 2 && nums[j] == nums[j-1]) {
        			j--;
        		}
        	}
        	while (i < nums.length - 3 && nums[i] == nums[i+1]) {
        		i++;
        	}
        }
        
        return res;
    }
}