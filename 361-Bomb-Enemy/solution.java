
public class Solution {
	public int maxKilledEnemies(char[][] grid) {
		int[][] row = new int[grid.length][grid[0].length];
		int[][] col = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				
				if (grid[i][j] == 'W') {
					continue;
				}
				
				row[i][j] += (j == 0 ? 0 : row[i][j - 1]);
				row[i][j] += (grid[i][j] == 'E'? 1 : 0);
			}
		}
		
		for (int j = 0; j < grid[0].length; j++) {
			for (int i = 0; i < grid.length; i++) {
				if (grid[i][j] == 'W') {
					continue;
				}
				
				col[i][j] += (i == 0? 0 : col[i-1][j]);
				col[i][j] += (grid[i][j] == 'E'? 1 : 0);
			}
		}
		
		int res = 0;
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (j != grid[0].length - 1 && row[i][j] != 0) {
					row[i][j] = Math.max(row[i][j], row[i][j+1]);
				}
				
				if (i != grid.length - 1 && col[i][j] != 0) {
					col[i][j] = Math.max(col[i][j], col[i+1][j]);
				}
				
				if (grid[i][j] == 'E') {
					res = Math.max(res, col[i][j] + row[i][j] - 1);
				} else { 
					res = Math.max(res, col[i][j] + row[i][j]);
				}
				
			}
		}

		return res;
	}

	
}