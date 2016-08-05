import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
    	result.add(new ArrayList<>());
    	Arrays.sort(nums);
    	int size = 1, last = nums[0];
    	for (int i = 0; i < nums.length; i++) {
    		if (last != nums[i]) {
    			last = nums[i];
    			size = result.size();
    		}
    		
    		List<List<Integer>> newSub = new ArrayList<>();
    		for (int j = result.size() - size; j < result.size(); j++) {
    			newSub.add(new ArrayList<>(result.get(j)));
    			newSub.get(newSub.size() - 1).add(nums[i]);
    		}
    		result.addAll(newSub);
    	}
    	
    	return result;
    }
}