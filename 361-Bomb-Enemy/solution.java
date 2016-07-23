public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int result = 0;
        int rowCache = 0;
        int[] colCache = new int[grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (j == 0 || grid[i][j-1] == 'W') {
        			rowCache = 0;
        			for (int k = j ; k < grid[0].length && grid[i][k] != 'W'; k++) {
        				rowCache += grid[i][k] == 'E' ? 1 : 0;
        			}
        		}
        		
        		if (i == 0 || grid[i-1][j] == 'W') {
        			colCache[j] = 0;
        			for (int k = i; k < grid.length && grid[k][j] != 'W'; k++) {
        				colCache[j] += grid[k][j] == 'E' ? 1 : 0;
        			}
        		}
        		
        		if (grid[i][j] == '0') {
        			result = Math.max(result, rowCache + colCache[j]);
        		}
        	}
        }
    	return result;
    }
}