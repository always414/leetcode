public class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
               int prev = i-1;
               int sub = 0;
               while (prev >= 0) {
                   if (s.charAt(prev) == ')' ) {
                        if (dp[prev] == 0) break;
                       sub += dp[prev];
                       prev -= dp[prev];
                   } else {
                       dp[i] += (sub+2);
                       prev -=1;
                       sub = 0;
                        if (prev >= 0 && s.charAt(prev) == '(') break;
                   }
               }
               
               dp[i] += sub;
            } 
            max = Math.max(max, dp[i]);
        }  
        
        return max;
    }
}