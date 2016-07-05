public class Solution {
	public String reverseString(String s) {
		char[] str = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			str[i] = s.charAt(s.length() - 1 - i);
		}

		return String.valueOf(str);
	}
}