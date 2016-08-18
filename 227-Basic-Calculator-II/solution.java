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
			}
			if (operator.contains(s.charAt(i))) {
				expression.add(s.substring(numstart, i));
				expression.add("" + s.charAt(i));
				numstart = i + 1;
			} else if (i == s.length() - 1) {
				expression.add(s.substring(numstart, i + 1));
			}
		}
		Deque<String> stack = new ArrayDeque<>();
		for (int i = expression.size() - 1; i >= 0; i--) {
			if (expression.get(i).equals("")) continue;
			if (!stack.isEmpty() && stack.peek().equals("*")) {
				stack.pop();
				Integer num = Integer.parseInt(stack.pop()) * Integer.parseInt(expression.get(i));
				stack.push("" + num);
			} else if (!stack.isEmpty() && stack.peek().equals("/")) {
				stack.pop();
				Integer num = Integer.parseInt(expression.get(i)) / Integer.parseInt(stack.pop());
				stack.push("" + num);
			} else {
				stack.push(expression.get(i));
			}
		}
		while (stack.size() > 1) {
			Integer num1 = Integer.parseInt(stack.pop());
			boolean plus = stack.pop().equals("+");
			Integer num2 = Integer.parseInt(stack.pop());
			Integer res = plus ? num1 + num2 : num2 - num1;
			stack.push("" + res);
		}

		return Integer.parseInt(stack.pop());
	}
}