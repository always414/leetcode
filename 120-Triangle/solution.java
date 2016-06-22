import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if (triangle == null || triangle.size() == 0) {
    		return 0;
    	}
    	if (triangle.size() == 1 ) {
    		return triangle.get(0).get(0);
    	}
    	
        for (int i = 1; i < triangle.size(); i++) {
        	for (int j = 0; j <= i; j++) {
        		if (j == 0) {
        			triangle.get(i).set(j, triangle.get(i-1).get(j) + triangle.get(i).get(j)); //last level j + current level j
        		} else if (j == i){
        			triangle.get(i).set(j, triangle.get(i-1).get(j-1) + triangle.get(i).get(j)); // last level j-1 + current level j
        		} else {
        			triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)));
        		}
        	}
        }
        return Collections.min(triangle.get(triangle.size()-1));
    }
}