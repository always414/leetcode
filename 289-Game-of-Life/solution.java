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

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1) {
					board[i][j] += getLiveNeighbor(board, i, j);
				} else {
					board[i][j] -= getLiveNeighbor(board, i, j);
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] > 0) {
					if (board[i][j] == 3 || board[i][j] == 4) {
						board[i][j] = 1;
					} else {
						board[i][j] = 0;
					}
				} else {
					if (board[i][j] == -3) {
						board[i][j] = 1;
					} else {
						board[i][j] = 0;
					}
				}
			}
		}
	}

	private int getLiveNeighbor(int[][] board, int i, int j) {
		int[] move = new int[] { 0, 1, 0, -1, 0 };
		int[] moveCorner = new int[] { 1, 1, -1, -1, 1 };
		int count = 0;

		for (int k = 0; k < move.length - 1; k++) {
			if (inRange(board, i + move[k], j + move[k + 1])) {
				count += board[i + move[k]][j + move[k + 1]] > 0 ? 1 : 0;
			}
			if (inRange(board, i + moveCorner[k], j + moveCorner[k + 1])) {
				count += board[i + moveCorner[k]][j + moveCorner[k + 1]] > 0 ? 1 : 0;
			}
		}

		return count;
	}

	private boolean inRange(int[][] board, int i, int j) {
		return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
	}
}