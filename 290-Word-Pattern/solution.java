import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] patternChars = pattern.toCharArray();
        String[] strs = str.split(" ");
        Set<String> set = new HashSet<>();
        
        if (patternChars.length != strs.length) {
        	return false;
        }
        
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < patternChars.length; i++) {
        	Character c = patternChars[i];
        	if (!map.containsKey(c)) {
        		map.put(c, strs[i]);
        		if (!set.add(strs[i])) return false;
        	}
        	
        	if (!map.get(c).equals(strs[i])) {
        		return false;
        	}
        			
        }
        return true;
    }
}