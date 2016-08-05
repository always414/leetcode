import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
    	result.add(new ArrayList<>());
    	subsets(result, 0, nums);
    	
    	return result;
    }
    
    private void subsets(List<List<Integer>> result, int i, int[] nums) {
    	if (i == nums.length) return;
    	List<List<Integer>> newSub = new ArrayList<>();
    	
    	for (List<Integer> list : result) {
    		List<Integer> newList = new ArrayList<>(list);
    		newList.add(nums[i]);
    		newSub.add(newList);
    	}
    	
    	result.addAll(newSub);
    	subsets(result, i + 1, nums);
    }
}