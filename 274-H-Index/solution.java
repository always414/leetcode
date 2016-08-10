import java.util.Arrays;

public class Solution {
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int hIndex = 0;
		int len = citations.length;
		for (int i = 0; i < citations.length; i++) {
				hIndex = Math.max(hIndex, Math.min(citations[i], len - i));
		}

		return hIndex;
	}
}