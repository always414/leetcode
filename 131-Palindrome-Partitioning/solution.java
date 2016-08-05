import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
    	List<List<String>> res = new ArrayList<>();
    	dfs(s, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(String s, List<String> list, List<List<String>> res) {
    	if (s.length() == 0) {
    		res.add(new ArrayList<>(list));
    		return;
    	}
    	
    	for (int i = 1; i <= s.length(); i++) {
    		if (isPalindrome(s.substring(0, i))) {
    			list.add(s.substring(0, i));
    			dfs(s.substring(i), list, res);
    			list.remove(list.size()-1);
    		}
    	}
    	
    }
    
    private boolean isPalindrome(String s) {
    	if (s == null || s.length() == 0) return false;
    	if (s.length() == 1) return true;
    	
    	char[] chars = s.toCharArray();
    	for (int i = 0, j = chars.length-1; i <= j; i++, j--) {
    		if (chars[i] != chars[j]) return false;
    	}
    	return true;
    }
}