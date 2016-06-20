import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<List<Integer>> res;
    public List<List<Integer>> getFactors(int n) {
        res = new ArrayList<>();
        int root = (int) Math.sqrt(n);
        int factor = 2;
        
        helper (factor, n, new ArrayList<Integer>());
        
    }
    
    public void helper (int factor, int number, List<Integer> factors) {
    	if (number <= fac)
    	
    	int rest = number / factor;
    	
    	
    	helper (factor + 1, number, factors);
    	
    	if (number <= factor) {
    		List<Integer> solution = new ArrayList<>();
    		solution.addAll(factors);
    		res.add(solution);
    		return;
    	}
    }
 }