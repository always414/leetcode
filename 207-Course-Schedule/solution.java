import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();
		

		int[] degree = new int[numCourses];
		Queue<Integer> queue = new ArrayDeque<>();
		int count = 0;
		
		for (int i = 0; i < numCourses;i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			degree[prerequisites[i][1]] ++;
			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0) {
				queue.add(i);
				count ++;
			}
		}

		while (! queue.isEmpty()) {
			int course =  queue.poll();
			for (int i = 0; i < graph.get(course).size(); i++) {
				int pointer = graph.get(course).get(i);
				degree[pointer] --;
				if (degree[pointer] == 0) {
					queue.add(pointer);
					count ++;
				}
			}
		}
		
		return count == numCourses;
	}
}