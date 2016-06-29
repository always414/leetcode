import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	if (s == null) {
    		throw new IllegalArgumentException("Null string input");
    	}
    	
    	if (s.length() == 0) {
    		return true;
    	}
    	
    	if (s.length() != 0 && wordDict.size() == 0) {
    		return false;
    	}
    	
    	boolean canBreak = false;
    	for (int i = 0; i < s.length() + 1; i++) {
    		if (wordDict.contains(s.substring(0, i))) {
//    			System.out.println(s.substring(0, i));
    			canBreak = wordBreak(s.substring(i), wordDict);
    			if (canBreak) {
    				return true;
    			}
    		}
    	}

    	return false;
    }
}