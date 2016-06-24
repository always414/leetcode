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
    	
    	for (String word : wordDic) {
    		if (s.startsWith(word)) {
    			solution.append(" ");
    			solution.append(word);
    			helper(list, s.substring(word.length()), wordDic, solution);
    			solution.delete(solution.length() - word.length() - 1, solution.length());
    		}
    	}
    }
}