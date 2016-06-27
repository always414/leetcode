import java.util.Arrays;

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		boolean[] row = new boolean[10];
		boolean[] col = new boolean[10];
		boolean[] cube = new boolean[10];

		for (int i = 0; i < 9; i++) {
			Arrays.fill(row, false); // reset row for every updating i;
			Arrays.fill(col, false);
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '0';
					if (row[num])
						return false;
					row[num] = true; // set number to true;
				}
				
				if (board[j][i] != '.') {
					int num = board[j][i] - '0';
					if (col[num]) return false;
					col[num] = true;
				}
				
				int rowIndex = 3 * (i/3);//0,0,0,1,1,1,2,2,2
				int colIndex = 3 * (i%3);//0,1,2,0,1,2,0,1,2
				
				if (board[rowIndex + j/3][colIndex + j%3] != '.') {
					int num = board[rowIndex + j/3][colIndex + j%3];
					if (cube[num]) return false;
					cube[num] = true;
				}
			}
		}

		return true;	
	}
}