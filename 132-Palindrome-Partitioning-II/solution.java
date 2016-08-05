public class Solution {
	int min = Integer.MAX_VALUE;

	//dfs or dynamic programming
	public int minCut(String s) {
		dfs(s, 0);
		return min;
	}

	private void dfs(String s, int cut) {
		if (s.length() == 0) {
			min = Math.min(cut - 1, min);
			return;
		}

		for (int i = 1; i <= s.length(); i++) {
			if (isPalindrome(s.substring(0, i))) {
				dfs(s.substring(i), cut + 1);
			}
		}
	}

	private boolean isPalindrome(String s) {
		if (s == null || s.length() == 0)
			return false;
		if (s.length() == 1)
			return true;

		char[] chars = s.toCharArray();
		for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
			if (chars[i] != chars[j])
				return false;
		}
		return true;
	}
}