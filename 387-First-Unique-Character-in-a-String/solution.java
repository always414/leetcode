import java.util.Arrays;

public class Solution {
	public int firstUniqChar(String s) {
		int[] alph = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			alph[c - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (alph[c - 'a'] == 1) {
				return i;
			}
		}

		return -1;
	}
}