import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
	public void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0) return;
		int width = rooms[0].length;
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
					if (rooms[i][j] == 0) {

						Queue<Integer> queue = new ArrayDeque<>();
						queue.add(i * width + j);

						while (!queue.isEmpty()) {
							int index = queue.poll();
							int row = index / width;
							int col = index % width;

							if (row - 1 >= 0 && rooms[row - 1][col] > rooms[row][col]) {
								rooms[row - 1][col] = rooms[row][col] + 1;
								queue.add(index - width);
							}

							if (row + 1 < rooms.length && rooms[row + 1][col] > rooms[row][col]) {
								rooms[row + 1][col] = rooms[row][col] + 1;
								queue.add(index + width);
							}

							if (col - 1 >= 0 && rooms[row][col - 1] > rooms[row][col]) {
								rooms[row][col - 1] = rooms[row][col] + 1;
								queue.add(index - 1);
							}

							if (col + 1 < width && rooms[row][col + 1] > rooms[row][col]) {
								rooms[row][col + 1] = rooms[row][col] + 1;
								queue.add(index + 1);
							}
						}
					}
			}
		}
		
		System.out.println(Arrays.deepToString(rooms));
	}
}