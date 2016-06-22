public class Solution {
    public int numDecodings(String s) {
        int[] matrix = new int[s.length() + 1];
        matrix[0] = 1;
        matrix[1] = 1;
        
        for (int i = 2; i < s.length() + 1; i++) {
        	matrix[i] = matrix[i-1];
        	if (Integer.parseInt(s.substring(i-2, i)) <= 26) {
        		matrix[i] += matrix[i-2];
        	};
        }
        return matrix[s.length()];
    }
}