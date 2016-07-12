import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
	
    public void solve(char[][] board) {
    	if (board.length == 0 || board[0].length == 0) return ;
    	int n = board[0].length;
    	int m = board.length;
    	
    	for (int row = 0; row < m; row ++) {
    		for (int col = 0; col < n; col ++) {
    			if (row == 0 || row == board.length - 1 || col == 0 || col == n - 1) {
    				if (board[row][col] == 'O') {
    					Queue<Integer> queue = new ArrayDeque<>();
    					board[row][col] = 'B';
    					queue.offer(row * n + col);
    					
    					while (! queue.isEmpty()) {
    						int cur = queue.poll();
    						int i = cur / n;
    						int j = cur % n;
    						
    						if (j + 1 < n && board[i][j+1] == 'O') {
    							queue.offer(cur + 1);
    							board[i][j+1] = 'B';
    						}
    						
    						if (i + 1 < m && board[i+1][j] == 'O') {
    							queue.offer(cur + n);
    							board[i+1][j] = 'B';
    						}
    						
    						if (j - 1 >= 0 && board[i][j-1] == 'O') {
    							queue.offer(cur - 1);
    							board[i][j-1] = 'B';
    						}
    						
    						if (i-1 >= 0 && board[i-1][j] == 'O') {
    							queue.offer(cur - n);
    							board[i-1][j] = 'B';
    						}
    								
    					}
    				}
    			}
    		}
    		
    		
    	}
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (board[i][j] == 'O') {
    				board[i][j] = 'X';
    			} else if (board[i][j] == 'B') {
    				board[i][j] = 'O';
    			}
    		}
    	}

    	System.out.println(Arrays.deepToString(board));
    	
    }
    
    

}