import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        
        final int[] shift = new int[] {0, 1, 0, -1, 0};
        
        int row = grid.length, col = grid[0].length;
        int[][] distance = new int[row][col];
        int[][] reach = new int[row][col];
        int buildingNum = 0;
        
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		if (grid[i][j] == 1) {
        			buildingNum ++;
        			Queue<int[]> queue = new ArrayDeque<>();
        			queue.offer(new int[]{i, j});
        			
        			boolean[][] isVisited = new boolean[row][col];
        			int level = 1;
        			
        			while (!queue.isEmpty()) {
        				int size = queue.size();
        				while (size -- > 0) {
        					int[] curr = queue.poll();
        					for (int k = 0; k < 4; k++) {
        						int nextRow = curr[0] + shift[k];
        						int nextCol = curr[1] + shift[k+1];
        						
        						if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col
        								&& grid[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]) {
        							distance[nextRow][nextCol] += level;
        							reach[nextRow][nextCol] ++;
        							
        							isVisited[nextRow][nextCol] = true;
        							queue.offer(new int[] {nextRow, nextCol});
        							//不会有反向的问题吗？
        						}
        					}
        				}
        				level ++;
        			}
        		}
        	}
        }
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
        			shortest = Math.min(shortest, distance[i][j]);
        		}
        	}
        }
        
        return shortest == Integer.MAX_VALUE? -1 : shortest;
    }
}