import java.util.Arrays;

public class Solution {
	public int maxProduct(String[] words) {
		int res = 0;
		if (words == null || words.length == 0) {
			return res;
		}

		int[] bitWords = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			String tmp = words[i];
			bitWords[i] = 0;
			for (int j = 0; j < tmp.length(); j++) {
				bitWords[i] |= 1 << (tmp.charAt(j) - 'a'); // beautiful, bitWords[i] = 0, 在字母位上 |= 1 
				// 1 << 位数 低位补0
			}
		}

		for (int i = 0; i < bitWords.length - 1; i++) {
			for (int j = i + 1; j < bitWords.length; j++) {
				if ((bitWords[i] & bitWords[j]) == 0 && words[i].length() * words[j].length() > res) {
					res = words[i].length() * words[j].length();
					// & if == 0, then no dup chars
				}
			}
		}
		return res;
	}
}