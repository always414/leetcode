import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        helper(result, s, wordDict, new StringBuilder());
        return result;
    }
    
    private void helper(List<String> list, String s, Set<String> wordDic, StringBuilder solution) {
    	
    	if (s.length() == 0 && solution.length() != 0) {
    		list.add(solution.toString().substring(1));
    		return;
    	}
    	
    	for (int i = 1; i <= s.length(); i++) {
    		if (wordDic.contains(s.substring(0, i))) {
    			solution.append(" ");
    			solution.append(s.substring(0, i));
    			helper(list, s.substring(i), wordDic, solution);
    			solution.delete(solution.length() - i - 1, solution.length()); // back track
    		}
    	}
    	
    	
    }
}