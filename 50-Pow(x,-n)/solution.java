public class Solution {
    public double myPow(double x, int n) {
    	if (n < 0) return 1 / powHelper(x, -n);
    	return powHelper(x, n);
    }
    
    private double powHelper(double x, int n) {
    	if (n == 0) return 1;
    	double half = powHelper(x, n / 2);
    	if (n % 2 == 0) return half * half;
    	return x * half * half;
    }
}