public class Solution {
    public boolean isPerfectSquare(int num) {
    	long start = 1, end = num/2;
        
        while (start + 1 < end) {
        	long mid = start + (end - start) / 2;
        	if (mid * mid == num) return true;
        	else if (mid * mid < num) {
        		start = mid;
        	}else {
        		end = mid;
        	}
        }
        
        return (start * start == num) || (end * end == num ) ;
    }
}