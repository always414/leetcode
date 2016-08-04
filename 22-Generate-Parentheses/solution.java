import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		helper(n, 0, new StringBuilder(), res);
		return res;
	}

	private void helper(int n, int rest, StringBuilder sb, List<String> res) {
		if (n < 0)
			return;

		if (n == 0 && rest == 0) {
			res.add(sb.toString());
			return;
		}

		if (rest > 0) {
			sb.append(")");
			helper(n, rest - 1, sb, res);
			sb.delete(sb.length() - 1, sb.length());
		}

		sb.append("(");
		helper(n - 1, rest + 1, sb, res);
		sb.delete(sb.length() - 1, sb.length());
	}

}