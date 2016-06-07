import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class SnakeGame {

	private int[][] board;
	private int score;
	private int length;
	private Queue<int[]> foodQue;
	private Deque<int[]> snake;

	private static final Map<String, int[]> moveCommand;

	static {
		moveCommand = new HashMap<>();
		moveCommand.put("U", new int[] { -1, 0 });
		moveCommand.put("D", new int[] { 1, 0});
		moveCommand.put("L", new int[] { 0, -1 });
		moveCommand.put("R", new int[] { 0, 1 });
	}

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
		board = new int[height][width];

		foodQue = new ArrayDeque<>();
		for (int[] pos : food) {
			foodQue.add(pos);
		}

		snake = new ArrayDeque<>();
		snake.add(new int[] { 0, 0 });

		score = 0;
		length = 1;
		initialize();
	}

	private void initialize() {
		board[0][0] = length;
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
			System.out.println("Error - invalid command");
			return -1;
		}

		int[] move = moveCommand.get(direction);
		int[] headPos = snake.peek();
		int[] newHead = new int[] { move[X] + headPos[X], move[Y] + headPos[Y] };

		if (!inBound(newHead)) {
			System.out.println("Game over, collide with bound!");
			return -1;
		}

		// a valid move
		if (getOccupation(newHead) == 0) {
			writeBoard(newHead, length);
			
			//for every body part, overwrite board to its val - 1
			// at last, if > 0, enque
			for (int i = 1; i <= length; i++) {
				int[] body = snake.poll();
				int val = Math.max(0, length - i);
				writeBoard(body, val);
				if (val > 0) {
					snake.add(body);
				}
			}
			
			snake.addFirst(newHead);
		}

		// eat a food
		else if (getOccupation(newHead) == FOOD) {
			score++;
			length++;
			writeBoard(newHead, length);
			System.out.println("Eat");
			snake.addFirst(newHead);
			// update food
			refreshFood();
		}

		// eat self
		else {
			System.out.println("Game over! Eat self.");
			return -1;
		}
//		System.out.println(Arrays.deepToString(board));
		return score;
	}

	private boolean refreshFood() {
		
		while (!foodQue.isEmpty()) {
			while (getOccupation(foodQue.peek()) != 0) {
				foodQue.poll();
			}
			break;
		}
		if (foodQue.isEmpty()) {
			return false;
		} else {
			writeBoard(foodQue.poll(), FOOD);
			return true;
		}
	}

	private void writeBoard(int[] pos, int val) {
		board[pos[X]][pos[Y]] = val;
	}

	private boolean inBound(int[] pos) {
		return pos[X] >= 0 && pos[Y] >= 0 && pos[X] < board.length && pos[Y] < board[0].length;
	}

	private int getOccupation(int[] pos) {
		return board[pos[X]][pos[Y]];
	}

}

/**
 * Your SnakeGame object will be instantiated and called as such: SnakeGame obj
 * = new SnakeGame(width, height, food); int param_1 = obj.move(direction);
 */