public class Solution {
	int globalLongest = 0;
    public int longestIncreasingPath(int[][] matrix) {
        	if (matrix.length == 0 || matrix[0].length == 0) {
    		return 0;
    	}
        int[][] dp = new int[matrix.length][matrix[0].length];
        helper(dp, matrix, 0, 0);
        return globalLongest;
    }
    
    private int helper(int[][] dp, int[][] matrix, int i, int j) {
    	if (i < 0 || j < 0 || i >= dp.length || j >= dp[0].length) {
    		return 0;
    	}
    	
    	if (dp[i][j] != 0) {
    		return dp[i][j];
    	}
    	
    	if (i >= 1 && matrix[i][j] > matrix[i-1][j]) {
    		dp[i][j] = Math.max(dp[i][j], helper(dp, matrix, i-1, j));
    	}
    	
    	if (i + 1 < dp.length && matrix[i][j] > matrix[i+ 1][j]) {
    		dp[i][j] = Math.max(dp[i][j], helper(dp, matrix, i+1, j));
    	}
    	
    	if (j >= 1 && matrix[i][j] > matrix[i][j-1]) {
    		dp[i][j] = Math.max(dp[i][j], helper(dp, matrix, i, j-1));
    	}
    	
    	if (j + 1 < dp.length && matrix[i][j] > matrix[i][j+1]) {
    		dp[i][j] = Math.max(dp[i][j], helper(dp, matrix, i, j+1));
    	}
    	
    	dp[i][j] += 1;
    	globalLongest = Math.max(globalLongest, dp[i][j]);	
    	return dp[i][j];
    }
}