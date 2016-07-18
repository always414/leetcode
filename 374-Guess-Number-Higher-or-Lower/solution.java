import java.util.Random;

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {

	public int guessNumber(int n) {
		int start = 1, end = n;
		while (start + 1 < end) {
			num = start + (end - start) / 2;
			if (guess(num) == 1) {
				start = num;
			} else if (guess(num == -1)) {
				end = num;
			} else {
				return num;
			}
		}
		
		return -1;

	}
}