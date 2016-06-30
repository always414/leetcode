/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
    	return binarySearch(1, n);
    	
    }
    
    private int binarySearch(int start, int end) {
    	if (start == end) {
    		return start;
    	}
    	
    	while (start + 1 < end) {
    		int mid = start + (end - start) /2;
    		if (isBadVersion(mid)) {
    			end = mid;
    		} else {
    			start = mid;
    		}
    	}
    	
    	return isBadVersion(start)? start : start + 1;
    }
}