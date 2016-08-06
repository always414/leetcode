import java.util.Arrays;

public class Solution {
	public void gameOfLife(int[][] board) {
		// 1.brute force
		// new board, and compute every node on old board -> very slow

		// 2.in place
		// traverse the board twice -> update each cell with the live neighbor
		// number
		// then update the number to 0 and 1
		// prevent recursion and side effect
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int lives = getLiveNeighbor(board, m, n, i, j);
				if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
					board[i][j] = 3;
				}

				if (board[i][j] == 0 && lives == 3) {
					board[i][j] = 2;
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] >>= 1;
			}
		}

	}

	private int getLiveNeighbor(int[][] board, int m, int n, int i, int j) {
		int count = 0;

		for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
			for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
				count += board[x][y] & 1;
			}
		}
		count -= board[i][j] & 1;
		return count;
	}

}