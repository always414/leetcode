public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) {
    		return 0;
    	}
    	
    	
    	int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length];
    	matrix[0][0] = 1;
    	
    	for (int i = 1; i < matrix[0].length; i++) {
    		if (obstacleGrid[0][i] == 0) {
    			matrix[0][i] = matrix[0][i-1];
    		} else {
    			break;
    		}
    	}
    	for (int i = 1; i < matrix.length; i++) {
    		if (obstacleGrid[i][0] == 0) {
    			matrix[i][0] = matrix[i-1][0];
    		} else {
    			break;
    		}
    	}
    	
    	for (int i = 1; i < matrix.length; i++) {
    		for (int j = 1; j < matrix[0].length; j++) {
    			if (obstacleGrid[i][j] == 1) {
    				matrix[i][j] = 0;
    			} else {
    				matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
    			}
    		}
    	}
        
        return matrix[matrix.length][matrix[0].length];
    }
}