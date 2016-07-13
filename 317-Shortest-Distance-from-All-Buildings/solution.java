import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    public int shortestDistance(int[][] grid) {
        int INF = Integer.MAX_VALUE;
        int width = grid[0].length;
        int[][] matrix = new int[grid.length][grid[0].length];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < grid.length; i++ ) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == 0) {
        			matrix[i][j] = 0;
        		} else if (grid[i][j] == 1) {
        			matrix[i][j] = 0;
        			queue.add(i * width + j);
        		} else {
        			matrix[i][j] = INF;
        		}
        	}
        }
        
        while(!queue.isEmpty()) {
        	int index = queue.poll();
        	int row = index / width;
        	int col = index % width;
        	
        	if (row + 1 < grid.length && grid[row + 1][col] == 0) {
        		matrix[row + 1][col] += (matrix[row][col] + 1);
        	}
        	
        }
        
        
        
    }
}