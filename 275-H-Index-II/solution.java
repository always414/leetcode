
public class Solution {
	public int hIndex(int[] citations) {
	    if (citations == null || citations.length == 0) return 0;
	    if (citations.length == 1) {
	        if (citations[0] == 0) {
	            return 0;
	        } else {
	            return 1;
	        }
	    }
		int hIndex = 0;
		int len = citations.length;
		int start = 0, end = citations.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (citations[mid] == len - mid) {
				return len-mid;
			}
			
			if (citations[mid] < len - mid) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return len - start;
	}

}