import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Solution {
	public boolean isReflected(int[][] points) {
		if (points == null || points.length < 2) {
			return true;
		}
		// find y
		Map<Double, Integer> map = new HashMap<>();
		int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
		for (int i = 0; i < points.length; i++) {
			map.put((double) points[i][0], points[i][1]);
			if (points[i][0] < minX) {
				minX = points[i][0];
			}
			if (points[i][0] > maxX) {
				maxX = points[i][0];
			}
		}
		double y = (minX + maxX) / 2.0;
		for (int i = 0; i < points.length; i++) {
			if (!map.containsKey((double)points[i][0])) continue;
			double x2 = 2 * y - points[i][0];
			if (map.get(x2) == points[i][1]) {
				map.remove(x2);
				map.remove((double)points[i][0]);
			} else {
				return false;
			}
		}
		return map.isEmpty();
	}
}