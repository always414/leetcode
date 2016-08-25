import java.util.Arrays;

public class Solution {
	public int longestValidParentheses(String s) {
		if (s.length() == 0)
			return 0;
		int[] dp = new int[s.length()];
		int max = 0;
		dp[0] = 0;
		for (int i = 1; i < s.length(); i++) {
			
			if (s.charAt(i) == '(') {
				if (s.charAt(i-1) == ')') {
					dp[i] += dp[i-1];
				} 
			} else {
				if (s.charAt(i-1) == '(') {
					dp[i] = dp[i-1] + 2;
				} else {
					int j = i - 1 - dp[i-1];
					if (j >= 0 && s.charAt(j) == '(') {
						dp[i] = dp[j] + 2 + dp[i-1];
 					}
				}
			}
			max = Math.max(max, dp[i]);
			
		}
		
		return max;

	}
}