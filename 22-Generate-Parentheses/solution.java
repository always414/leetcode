import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	Set<String> res;

	public List<String> generateParenthesis(int n) {
		res = new HashSet<>();
		helper(n, 0, new StringBuilder());
		return new ArrayList<>(res);
	}

	private void helper(int n, int rest, StringBuilder sb) {
		if (n < 0)
			return;

		if (n == 0 && rest == 0) {
			res.add(sb.toString());
			return;
		}
		
		if (rest > 0) {
			for (int tmp = 1; tmp <= rest; tmp++) {
				sb.append(")");
				helper(n, rest - tmp, sb);
			}
			sb.delete(sb.length() - rest, sb.length());
		}

		sb.append("(");
		helper(n - 1, rest + 1, sb);
		sb.delete(sb.length() - 1, sb.length());
	}

}