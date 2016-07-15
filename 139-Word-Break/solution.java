import java.util.Arrays;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
        	for (int j = i-1; j >= 0; j--) {
        		if (dp[j] && wordDict.contains(s.substring(j, i))) {
        			dp[i] = true;
        		}
        	}
        }
        return dp[s.length()];
    }
}