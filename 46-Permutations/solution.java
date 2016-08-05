import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        	sub.add(nums[i]);
        }

        permuteHelper(result, sub, 0);
        return result;
    }
    
    private void permuteHelper(List<List<Integer>> result, List<Integer> sub, int start) {
    	if (start > sub.size()) return;

    	if (start == sub.size()) {
    		result.add(new ArrayList<>(sub));
    	}

    	for (int i = start; i < sub.size(); i++) {
    		Collections.swap(sub, start, i);
    		permuteHelper(result, sub, start + 1);
    		Collections.swap(sub, start, i);
    	}
    }
}