public class Solution {
    public int climbStairs(int n) {
        if (n < 3) {
        	return n;
        }
    	int[] matrix = new int[n+1];
        //OPT(i) = OPT(i-1) + OPT(i-2)
        
        matrix[0] = 0;
        matrix[1] = 1;
        matrix[2] = 2;
        
        
        for (int i = 3; i <= n; i++) {
        	matrix[i] = matrix[i-1] + matrix[i-2];
        }
        
        return matrix[n];
    }
} 