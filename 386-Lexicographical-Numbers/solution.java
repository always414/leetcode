import java.util.*;

public class Solution {
	public List<Integer> lexicalOrder(int n) {
		// dfs
		List<Integer> array = new ArrayList<>();
		backtrackingHelper(n, 0, array);
		array.remove(0);
		return array;
	}

	public void backtrackingHelper(int n, int num, List<Integer> array) {
		if (num > n) return;
		for (int i = 0; i <= 9 && num <= n; i++) {
			array.add(num);
			if (num * 10 < n) {
				backtrackingHelper(n, num * 10, array);
			}
			num ++;
		}
	}
}