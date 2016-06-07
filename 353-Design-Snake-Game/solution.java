import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class SnakeGame {

	private Queue<int[]> foodQue;
	private Deque<int[]> snake;

	private static final Map<String, int[]> moveCommand;
	static {
		moveCommand = new HashMap<>();
		moveCommand.put("U", new int[] { -1, 0 });
		moveCommand.put("D", new int[] { 1, 0 });
		moveCommand.put("L", new int[] { 0, -1 });
		moveCommand.put("R", new int[] { 0, 1 });
	}

	private final int width;
	private final int height;
	private static final int X = 0;
	private static final int Y = 1;
	private static final int FOOD = Integer.MAX_VALUE;

	/**
	 * Initialize your data structure here.
	 * 
	 * @param width
	 *            - screen width
	 * @param height
	 *            - screen height
	 * @param food
	 *            - A list of food positions E.g food = [[1,1], [1,0]] means the
	 *            first food is positioned at [1,1], the second is at [1,0].
	 */
	public SnakeGame(int width, int height, int[][] food) {
		this.width = width;
		this.height = height;
		
		foodQue = new ArrayDeque<>();
		for (int[] pos : food) {
			foodQue.add(pos);
		}

		snake = new ArrayDeque<>();
		snake.add(new int[] { 0, 0 });

		refreshFood();
	}

	/**
	 * Moves the snake.
	 * 
	 * @param direction
	 *            - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
	 * @return The game's score after the move. Return -1 if game over. Game
	 *         over when snake crosses the screen boundary or bites its body.
	 */
	public int move(String direction) {
		if (!moveCommand.containsKey(direction)) {
			return -1;
		}

		int[] move = moveCommand.get(direction);
		int[] oldHead = snake.peek();
		int[] newHead = new int[] { move[X] + oldHead[X], move[Y] + oldHead[Y] };

		if (!inBound(newHead)) {
			// System.out.println("Game over, collide with bound!");
			return -1;
		}

		// a valid move
		if (getOccupation(newHead) == 0) {
			snake.removeLast();
			snake.addFirst(newHead);
		}

		// eat a food
		else if (getOccupation(newHead) == FOOD) {
			snake.addFirst(newHead);
			refreshFood();
		}

		// eat self
		else {
			assert (getOccupation(newHead) == -1);
			return -1;
		}
		
		return snake.size()-1;
	}

	private boolean refreshFood() {
		while ((!foodQue.isEmpty()) && (!inBound(foodQue.peek()) || getOccupation(foodQue.peek()) != 0)) {
			foodQue.poll();
		}
		return !foodQue.isEmpty();
	}

	
	private boolean inBound(int[] pos) {
		return pos[X] >= 0 && pos[Y] >= 0 && pos[X] < height && pos[Y] < width;
	}

	private int getOccupation(int[] pos) {
		if (snake.contains(pos)) {
			return -1;
		} else if (foodQue.peek().equals(pos)) {
			return FOOD;
		} else {
			return 0;
		}
	}

}

/**
 * Your SnakeGame object will be instantiated and called as such: SnakeGame obj
 * = new SnakeGame(width, height, food); int param_1 = obj.move(direction);
 */