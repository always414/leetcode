import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	private static Set<Character> VOWERS;
	static {
		VOWERS = new HashSet<>();
		VOWERS.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
	}

	public String reverseVowels(String s) {
		char[] chars = s.toCharArray();
		for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
			while (i < s.length() && !VOWERS.contains(chars[i])) {
				i++;
			}
			while (j >= 0 && !VOWERS.contains(chars[j])) {
				j--;
			}
			if (i < j && VOWERS.contains(chars[i]) && VOWERS.contains(chars[j])) {
				swap(chars, i, j);
			}
		}
		return String.copyValueOf(chars);
	}

	private void swap(char[] chars, int i, int j) {
		char c = chars[i];
		chars[i] = chars[j];
		chars[j] = c;
	}
}