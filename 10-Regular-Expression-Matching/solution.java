public class Solution {
    public boolean isMatch(String s, String p) {
    	boolean[][] matrix = new boolean[s.length() + 1][p.length() + 1];
    	// matrix is initialized as all false
    	//initialize: empty matches empty
        matrix[0][0] = true;
        for (int j = 1; j < matrix[0].length; j++) {
        	if (p.charAt(j-1) == '*') {
        		assert (j > 1); // since p can not start with '*' -> invalid input
        		matrix[0][j] |= matrix[0][j-2];
        	}
        }

        for (int i = 1; i < matrix.length; i++) {
        	for (int j = 1; j < matrix[0].length; j++) {
        		if (p.charAt(j-1) == '.') {
        			matrix[i][j] = matrix[i-1][j-1];
        		}
        		
        		if (p.charAt(j-1) == s.charAt(i-1)) {
        			matrix[i][j] = matrix[i-1][j-1];
        		}
        		
        		if (p.charAt(j-1) == '*') {
        			if (p.charAt(j-1) != s.charAt(i-1) && p.charAt(i-1) != '.') {
        				//empty case
        				matrix[i][j] = matrix[i][j-2];
        			} else {
        				//either of three
        				matrix[i][j] = matrix[i-1][j] || matrix[i][j-1] || matrix[i][j-2];
        			}
        		}
        	}
        }

        
        return matrix[s.length()][p.length()];
    }
    
   

}