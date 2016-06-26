import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       Arrays.sort(candidates);
       List<List<Integer>> result = new ArrayList<>();
       helper(result, new ArrayList<Integer>(), candidates, target, 0);
       
       return result;
        
    }
    
    private void helper (List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int index) {
    	if (target == 0) {
    		result.add(new ArrayList<>(list));
    	}
    	
    	if (target < 0) {
    		return;
    	}
    	
    	for (int i = index; i < candidates.length; i++) {

    		if (candidates[i] > target) {
    			break;
    		}
    		list.add(candidates[i]);
    		helper(result, list, candidates, target - candidates[i], i + 1);
    		list.remove(list.size() - 1);
    		
    		while (i < candidates.length - 1 
    				&& candidates[i] == candidates[i+1]) {
    				i++;
    		}
    		
    	}
    }
}