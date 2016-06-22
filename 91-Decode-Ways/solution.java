public class Solution {
    public int numDecodings(String s) {
    	if (s == null || s.length() == 0 || s.charAt(0) == '0') {
    		return 0;
    	}
    	
        int[] matrix = new int[s.length() + 1];
        matrix[0] = 1;
        matrix[1] = 1;
        for (int i = 2; i < s.length() + 1; i++) {
        	int single = Integer.parseInt(s.substring(i-1, i));
        	int two = Integer.parseInt(s.substring(i-2, i));
        	if (single == 0 && (two >26 || two < 1)) {
        		return 0;
        	}
        	
        	if (single != 0) {
        		matrix[i] = matrix[i-1];
        	}
        	
        	if (two >= 10 && two <= 26) {
        		matrix[i] += matrix[i-2];
        	}
        }
        return matrix[s.length()];
    }
}