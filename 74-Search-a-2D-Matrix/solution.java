public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return false;
        }
        
        int start = 0, end = matrix.length * matrix[0].length - 1;
        int x, y;
        
        while (start + 1 < end) {
        	int mid = start + (end - start)/2;
        	x = mid / matrix.length;
        	y = mid % matrix.length;
        	
        	if (x < 0|| y < 0) {
        		return false;
        	}
        	
        	if (matrix[x][y] == target) {
        		return true;
        	} else if (matrix[x][y] < target ) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }
        
        x = start / matrix.length;
        y = start % matrix.length;
        
        if (x >= 0 && y >= 0 && matrix[x][y] == target ){
        	return true;
        }
        
        x = end / matrix.length;
        y = end % matrix.length;
        
        if (x >= 0 && y >= 0 && matrix[x][y] == target ){
        	return true;
        }

        return false;
    }
}