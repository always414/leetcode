public class Solution {
	public int[] getModifiedArray(int length, int[][] updates) {
		int[] res = new int[length];

		for (int i = 0; i < updates.length; i++) {
			int start = updates[i][0];
			int end = updates[i][1] + 1;
			res[start] += updates[i][2];
			if (end < res.length) {
				res[end] -= updates[i][2];
			}
		}

		for (int i = 1; i < res.length; i++) {
			res[i] += res[i - 1];
		}
		return res;
	}
}