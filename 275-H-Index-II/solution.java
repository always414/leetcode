
public class Solution {
	public int hIndex(int[] citations) {
		int hIndex = 0;
		int len = citations.length;
		int start = 0, end = citations.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			int min = Math.min(citations[mid], len - mid);
			if (min >= hIndex) {
				hIndex = min;
				start = mid;
			} else {
				end = mid;
			}
		}

		hIndex = Math.max(Math.max(Math.min(citations[start], len - start), Math.min(citations[end], len - end)),
				hIndex);
		return hIndex;
	}

}