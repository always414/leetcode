import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        
        List<Set<Integer>> adjacent = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adjacent.add(new HashSet<>());
        
        for (int[] edge : edges) {
        	adjacent.get(edge[0]).add(edge[1]);
        	adjacent.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	if (adjacent.get(i).size() == 1) leaves.add(i);
        }
        
        while (n > 2) {
        	n -= leaves.size();
        	List<Integer> newLeaves = new ArrayList<>();
        	for (int leave : leaves) {
        		int j = adjacent.get(leave).iterator().next();//leave only has one edge. thus only one next
        		adjacent.get(j).remove(leave);
        		if (adjacent.get(j).size() == 1) newLeaves.add(j);
        	}
        	leaves = newLeaves;
        }
        
        return leaves;
    }
}