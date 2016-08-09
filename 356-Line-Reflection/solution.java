public class Solution {
	public boolean isReflected(int[][] points) {
		if (points == null || points.length < 2 || points[0].length < 2) {
			return true;
		}
		// find y
		int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
		for (int i = 0; i < points.length; i++) {
			if (points[i][0] < minX) {
				minX = points[i][0];
			} 
			if (points[i][0] > maxX) {
				maxX = points[i][0];
			}
		}
		
		double y = (minX + maxX) / 2;
		
		double dist = 0;
		for (int i = 0; i < points.length; i++) {
			dist ^= Math.abs(y - points[i][0]);
			dist ^= points[i][1];
		}
		return dist == 0;
	}
}