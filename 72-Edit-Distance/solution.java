public class Solution {
    public int minDistance(String word1, String word2) {
        //convert w1 to w2;
    	//insert, delete, replace
    	
    	int m = word1.length();
    	int n = word2.length();
    	
    	int[][] matrix = new int[m + 1][n + 1];
    	
    	for (int i = 1; i <= m; i++) {
    		matrix[i][0] = i;
    	}
    	for (int j = 0; j <= n; j++) {
    		matrix[0][j] = j;
    	}
    	
    	for (int i = 1; i <= m; i++) {
    		for (int j = 1; j <= n; j++) {
    			if (word1.charAt(i-1) == word2.charAt(j-1)) {
    				matrix[i][j] = matrix[i-1][j-1];
    			} else {
    				matrix[i][j] = 1 + Math.min( matrix[i-1][j-1], // replace word1(i)
    						Math.min(matrix[i][j-1], //word2(j) is not match, insert word1(i)
    								matrix[i-1][j]));  //word1(i) is not match, delete word1(i)
    			}
			}
    	}
    	return matrix[m][n];
    }
}