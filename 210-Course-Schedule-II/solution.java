import java.nio.file.ProviderNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       int[] order = new int[numCourses];
       int[] preCount = new int[numCourses];
       int num = 0;
       
       for (int i = 0; i < prerequisites.length; i++) {
    	   int course = prerequisites[i][0];
    	   int pre = prerequisites[i][1];
    	   preCount[course] ++;
       }

       Queue<Integer> queue = new ArrayDeque<>();
       for (int i = 0; i < preCount.length; i++) {
    	   if (preCount[i] == 0) {
    		   queue.add(i);
    		   preCount[i] = Integer.MAX_VALUE;
    	   }
       }
       
       while (!queue.isEmpty()) {
    	   int preCourse = queue.poll();
    	   order[num++] = preCourse;
    	   for (int i = 0; i < prerequisites.length; i++) {
    		   if (prerequisites[i][1] == preCourse) {
    			   preCount[prerequisites[i][0]] --;
    			   if (preCount[prerequisites[i][0]] == 0) {
    				   queue.add(prerequisites[i][0]);
    			   }
    		   }
    	   }
       }
       
       

        return num == numCourses? order : new int[0];
    }
}