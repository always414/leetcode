import java.util.Random;

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {

	public int guessNumber(int n) {
		int start = 1, end = n;
		int num = pickRandom(1, n);

		while (true) {
			if (guess(num) == 1) {
				start = num;
				num = pickRandom(num, end);
			} else if (guess(num) == -1) {
				end = num;
				num = pickRandom(start, num);
			} else {
				return num;
			}
			if (num == -1) 
				break;
		}
		
		return -1;

	}

	private int pickRandom(int start, int end) {
		if (start < 0 || start > end)
			return -1;
		int index = start + (end - start) / 2;
		return index;
	}
}