import java.util.Arrays;

public class Solution {
	// dfs or dynamic programming
	public int minCut(String s) {
		char[] c = s.toCharArray();
		int[] cut = new int[s.length()];
		boolean[][] pal = new boolean[s.length()][s.length()];

		for (int i = 0; i < cut.length; i++) {
			int min = i;
			for (int j = 0; j <= i; j++) {
				if (c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
					pal[j][i] = true;
					min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
				}
			}
			cut[i] = min;
		}
		return cut[cut.length - 1];
	}

}