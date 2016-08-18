import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;

public class Solution {
	static HashSet<Character> operator;
	static {
		operator = new HashSet<>();
		operator.add('+');
		operator.add('-');
		operator.add('*');
		operator.add('/');
	}

	public int calculate(String s) {
		ArrayList<String> expression = new ArrayList<>();
		int numstart = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if (!s.substring(numstart, i).isEmpty()) {
					expression.add(s.substring(numstart, i));
				}
				numstart = i + 1;
			} else if (operator.contains(s.charAt(i))) {
				expression.add(s.substring(numstart, i));
				expression.add("" + s.charAt(i));
				numstart = i + 1;
			} else if (i == s.length() - 1) {
				expression.add(s.substring(numstart, i + 1));
			}
		}

		// first round, calculate * and /
		for (int i = 0; i < expression.size() && expression.size() > 1; i++) {
			if (expression.get(i).isEmpty()) {
				expression.remove(i);
				i--;
				continue;
			}

			if (expression.get(i).equals("*") || expression.get(i).equals("/")) {
				Integer left = Integer.parseInt(expression.get(i - 1));
				boolean multiple = expression.get(i).equals("*");
				Integer right = Integer.parseInt(expression.get(i + 1));
				Integer res = multiple ? left * right : left / right;

				expression.remove(i + 1);
				expression.remove(i);
				expression.remove(i - 1);
				i--;
				expression.add(i, "" + res);
			}
		}

		// second round, calculate + and -
		for (int i = 0; i < expression.size() && expression.size() > 1; i++) {
			if ("+-".contains(expression.get(i))) {
				Integer left = Integer.parseInt(expression.get(i - 1));
				boolean plus = expression.get(i).equals("+");
				Integer right = Integer.parseInt(expression.get(i + 1));
				Integer res = plus ? left + right : left - right;

				expression.remove(i + 1);
				expression.remove(i);
				expression.remove(i - 1);
				i--;
				expression.add(i, "" + res);
			}
		}

		return Integer.parseInt(expression.get(0));
	}
}