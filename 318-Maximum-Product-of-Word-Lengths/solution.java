import java.util.Arrays;

public class Solution {
	public int maxProduct(String[] words) {
		int res = 0;
		if (words == null || words.length == 0) {
			return res;
		}

		int[] bitWords = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			char[] chars = new char[26];
			Arrays.fill(chars, '0');
			for (int j = 0; j < words[i].length(); j++) {
				chars[25 - words[i].charAt(j) + 'a'] = '1';
			}
			bitWords[i] = Integer.parseInt(String.valueOf(chars), 2);
		}

		for (int i = 0; i < bitWords.length - 1; i++) {
			for (int j = i + 1; j < bitWords.length; j++) {
				if (Integer.bitCount(bitWords[i]) + Integer.bitCount(bitWords[j]) == Integer
						.bitCount(bitWords[i] ^ bitWords[j])) {
					res = Math.max(res, words[i].length() * words[j].length());
				}
			}
		}
		return res;
	}
}