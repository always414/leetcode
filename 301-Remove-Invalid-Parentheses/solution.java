import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
	public List<String> removeInvalidParentheses(String s) {
		if (isValid(s)) {
			return Collections.singletonList(s);
		}

		List<String> res = new ArrayList<>();
		Queue<Tuple> queue = new ArrayDeque<>();
		queue.add(new Tuple(s, 0, ')'));
		while (!queue.isEmpty()) {
			Tuple x = queue.poll();
			for (int i = x.start; i < x.str.length(); ++i) {
				char ch = x.str.charAt(i);

				if (ch != '(' && ch != ')')
					continue;
				if (i != x.start && x.str.charAt(i - 1) == ch)
					continue;
				if (x.removed == '(' && ch == ')')
					continue;

				String t = x.str.substring(0, i) + x.str.substring(i + 1);

				if (isValid(t))
					res.add(t);

				else if (res.isEmpty())
					queue.add(new Tuple(t, i, ch));
			}
		}

		return res;

	}

	private boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				count++;
			if (c == ')' && count-- == 0)
				return false;
		}

		return count == 0;
	}

	private class Tuple {
		public final String str;
		public final int start;
		public final char removed;

		public Tuple(String str, int start, char removed) {
			this.str = str;
			this.start = start;
			this.removed = removed;
		}
	}

}