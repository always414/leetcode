import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.print.attribute.HashAttributeSet;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
    	if (points == null) {
    		return 0;
    	}
    	if (points.length <= 2) {
    		return points.length;
    	}
    	int result = 0;
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i = 0; i < points.length - 1; i++) {
    		int overlap = 0;
    		for (int j = i + 1; j < points.length; j++) {
    			if (points[i].x == points[j].x && points[i].y ==points[j].y) {
    				overlap ++;
    			} else {
    				double k = 0;
    				double c = 0;
    				if (points[i].x == points[j].x) {
    					k = Double.MAX_VALUE;
    				} else if (points[i].y == points[j].y) {
    					c = points[i].y;
    				} else {
    					k = (points[j].y - points[i].y) / (points[j].x - points[i].x);
    					c = points[i].y - points[i].x * k;
    				}
    				int hashVal = Objects.hash(k, c);
    				map.put(hashVal, map.getOrDefault(hashVal, 0) + 1);
    			}
    		}
    		result = Math.max(result, Collections.max(map.values()) + overlap + 1);
    	}
    	return result;
    }
}