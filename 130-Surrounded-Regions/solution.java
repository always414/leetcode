public class Solution {
	private static int[] I = {0, 0, 1, -1};
	private static int[] J = {1, -1, 0, 0};
	
    public void solve(char[][] board) {
    	if (board == null || board.length == 0 || board[0].length == 0) {
    		return ;
    	}
        for (int i = 0; i < board.length; i += board.length - 1) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == 'O') {
        			paintHelper(board, i, j, 'B');
        		}
        	}
        }
        
        for (int j = 0; j < board[0].length; j+= board[0].length - 1) {
        	for (int i = 0; i < board.length; i++) {
        		if (board[i][j] == 'O') {
        			paintHelper(board, i, j, 'B');
        		}
        	}
        }
        
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == 'O') {
        			board[i][j] = 'X';
        		} else if (board[i][j] == 'B') {
        			board[i][j] = 'O';
        		}
        	}
        }
    	
    }
    
    private void paintHelper(char[][] board, int i, int j, char c) {
    	if (i < 0 || j < 0 || i > board.length || j > board[0].length || board[i][j] == 'X') {
    		return;
    	}
    	
    	board[i][j] = c;
    	
    	for (int k = 0; k < 4; k++) {
    		paintHelper(board, i + I[k], j + J[k], c);
    	}
    }
}