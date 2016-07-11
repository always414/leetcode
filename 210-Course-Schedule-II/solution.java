import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       int[] order = new int[numCourses];
       int num = 0;
        List<Set<Integer>> pre = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
        	pre.add(new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
        	pre.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < pre.size(); i++) {
        	if (pre.get(i).isEmpty()) {
        		queue.add(i);
        	}
        }
        while (! queue.isEmpty()) {
//        	System.out.println(queue);
        	Integer course = queue.poll();
        	order[num++] = course;
        	for (int i = 0; i < pre.size(); i++) {
//        		System.out.println(pre.get(i).remove(course));
        		if (pre.get(i).remove(course)) {
        			if (pre.get(i).isEmpty()){
        				queue.add(i);
        			}
        		}
        	}
        }
        return num == numCourses? order : new int[0];
    }
}