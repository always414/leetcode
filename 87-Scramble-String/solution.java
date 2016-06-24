public class Solution {
	public boolean isScramble(String s1, String s2) {
		if (s2.equals(s1)) {
			return true;
		}

		
		for (int i = 1; i < s1.length(); i++) {
			// compare every substring from (0,i) (i,length)
			// if true, return result;
			if (!s2.contains("" + s1.charAt(i-1))) {
				return false;
			}
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