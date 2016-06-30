public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		// first find range of row index -> convert to -> find the largest number smaller than target on matrix[i][0]
		int startRow = 0, endRow = matrix.length - 1;

		while (startRow + 1 < endRow) {
			int midRow = startRow + (endRow - startRow) / 2;
			if (matrix[midRow][0] < target) {
				startRow = midRow;
			} else if (matrix[midRow][0] > target) {
				endRow = midRow;
			} else {
				return true;
			}
		}

		
		if (matrix[startRow][0] == target || matrix[endRow][0] == target ) {
			return true;
		}
		
		int rowIndex = 0;
		if (matrix[endRow][0] < target) {
			rowIndex = endRow;
		} else {
			rowIndex = matrix[startRow][0] < target? startRow : startRow - 1;
		}
		
		if (rowIndex < 0) return false;
		
		// second find the location of col index
		int startCol = 0, endCol = matrix[0].length - 1;
		while (startCol + 1 < endCol) {
			int midCol = startCol + (endCol - startCol) / 2;
			if (matrix[rowIndex][midCol] == target) {
				return true;
			} else if (matrix[rowIndex][midCol] < target ){
				startCol = midCol;
			} else {
				endCol = midCol;
			}
		}
		
		return matrix[rowIndex][startCol] == target || matrix[rowIndex][endCol] == target;
	}
}