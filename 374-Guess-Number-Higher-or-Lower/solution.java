

import java.util.Random;

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
	Random r;

	public int guessNumber(int n) {
		r = new Random();
		int start = 0, end = n + 1;
		int num = pickRandom(0, n + 1);

		while (true) {
			if (guess(num) == 1) {
				// my number is higher
				start = num;
				num = pickRandom(num, end);

			} else if (guess(num) == -1) {
				end = num;
				num = pickRandom(start, num);

			} else {
				return num;
			}
			
			if (num == -1) return -1;
		}
		
		return -1;

	}

	private int pickRandom(int start, int end) {
		if (start < 0 || start > end)
			return -1;
		int index = r.nextInt(end - start) + start;
		return index;
	}
}