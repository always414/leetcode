public class Solution {
	
	private static int[] I = {0, 0, 1, -1};
	private static int[] J = {1, -1, 0, 0};
	
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == '1') {
        			dfs(grid, i, j);
        			count ++;
        		}
        	}
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j) {
    	if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
    		return;
    	}
    	
    	grid[i][j] = '0';
    	for (int k = 0; k < 4; k++) {
    		dfs (grid, i + I[k], j + J[k]);
    	}
    	
    }
}