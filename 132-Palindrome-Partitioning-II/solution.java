import java.util.Arrays;

public class Solution {
	//dfs or dynamic programming
	public int minCut(String s) {
		int[] matrix = new int[s.length() + 1];
		Arrays.fill(matrix, Integer.MAX_VALUE);
		matrix[0] = 0;
		
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				if (matrix[j] == Integer.MAX_VALUE || matrix[j] + 1 => matrix[i]) continue;
				
				if (isPalindrome(s.substring(j, i))) {
					matrix[i] = Math.min(matrix[j] + 1, matrix[i]);
//					break;
				}
			}
		}
		return matrix[matrix.length - 1] - 1;
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