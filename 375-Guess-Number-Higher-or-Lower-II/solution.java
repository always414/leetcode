public class Solution {
	int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n+1][n+1];
        
        return getRange(1, n);
    }
    
    private int getRange(int begin, int end) {
    	if (begin >= end) {
    		return 0;
    	} 
    	
    	if (dp[begin][end] != 0) {
    		return dp[begin][end];
    	}
    	int miniMax = Integer.MAX_VALUE;
    	for (int i = begin; i <= end; i++) {
    		int max = Math.max(getRange(begin, i-1), getRange(i + 1, end)) + i;
    		miniMax = Math.min(miniMax, max);
    	}
    	
    	dp[begin][end] = miniMax;
    	return miniMax;
    }
}