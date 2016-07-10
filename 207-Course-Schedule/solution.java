import java.util.ArrayList;
import java.util.List;

public class Solution {
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
 
    	if (prerequisites == null || prerequisites.length == 0) {
    		return true;
    	}
        
    	// an array represents that how many prerequisites each index course should take
    	ArrayList<Integer> preCourse = new ArrayList<>();
    	for (int i = 0; i < numCourses; i++) {
    		preCourse.add(0); // set initial weight to 0.
    	}
    	//for every pair in matrix, adding weights to preReq
    	for (int i = 0; i < prerequisites.length; i++) {
    		int course = prerequisites[i][0];
    		preCourse.set(course, preCourse.get(course) + 1);
    	}
    	
    	// return first index or -1 when no content
    	List<Integer> noPre = new ArrayList<>();
    	while (preCourse.indexOf(0) != -1) {
    		//get course index with 0 income weights
        	int courseIndex = preCourse.indexOf(0);
        	if (courseIndex == -1) continue;
        	
        	//for every course which has weights of 0
        	//decrement weights that require itself as a prerequisite.
        	noPre.add(courseIndex);
        	for (int i = 0; i < prerequisites.length; i++) {
        		if (courseIndex == prerequisites[i][1]) {
        			preCourse.set(prerequisites[i][0], preCourse.get(prerequisites[i][0]) - 1);
        		}
        	}
        	//delete node in graph, set val to max.
        	preCourse.set(courseIndex, Integer.MAX_VALUE);
    	}
    	return numCourses == noPre.size();
    }
}