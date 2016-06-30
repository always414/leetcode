public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return false;
        }
        
        int start = 0, end = matrix.length * matrix[0].length - 1;
        int x, y;
        
        while (start + 1 < end) {
        	int mid = start + (end - start)/2;
        	x = mid / matrix[0].length;
        	y = mid % matrix[0].length;
        	
        	if (matrix[x][y] == target) {
        		return true;
        	} else if (matrix[x][y] < target ) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }
        
        
        if (matrix[start / matrix[0].length][ start % matrix[0].length] == target ){
        	return true;
        } else if (matrix[end / matrix[0].length][ end % matrix[0].length] == target ){
        	return true;
        }

	return false;
}}