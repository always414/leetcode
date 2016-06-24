public class Solution {
	public boolean isScramble(String s1, String s2) {
		if (s2.equals(s1)) {
			return true;
		}
		int[] letters = new int[26];
        for (int i=0; i<s1.length(); i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
		
		for (int i = 1; i < s1.length(); i++) {
			// compare every substring from (0,i) (i,length)
			// if true, return result;
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) 
					&& isScramble(s1.substring(i), s2.substring(i))) {
				return true;
			}
			if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) 
					&& isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
				return true;
			}
		}
		return false;
	}
}