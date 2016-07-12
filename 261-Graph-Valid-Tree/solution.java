// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1 && edges.length == 0) {
            return true;
        }
    	int edgeNum = 0;
    	
    	List<Set<Integer>> tree = new ArrayList<>(n);
    	for (int i = 0; i < n; i++) {
    		tree.add(new HashSet<Integer>());
    	}
    	
    	
    	for (int[] edge : edges) {
    		if (tree.get(edge[0]).add(edge[1]) && tree.get(edge[1]).add(edge[0]) ) {
    		    edgeNum ++;
    		};
    	}
    	
    	
    	//inspect tree cycle.
    	if (edgeNum != n-1) {
    		return false;
    	}
    	
    	// inspect island node.
    	for (Set<Integer> connections: tree) {
    		if (connections.isEmpty()) {
    			return false;
    		}
    	}
    	
    	//inspect sub cycles
    	Queue<Integer> queue = new ArrayDeque<>();
    	queue.offer(0);
    	while (!queue.isEmpty()) {
    	    Integer node = queue.poll();
    	    Set<Integer> connections = tree.get(node);
    	    
    	    for (Integer neighbour : connections) {
    	        tree.get(neighbour).remove(node);
    	        if (!tree.get(neighbour).isEmpty()) {
    	            queue.offer(neighbour);
    	        }
    	    }
    	    
    	    tree.get(node).clear();
    	}
    	
    	for (Set<Integer> nodeConnections : tree) {
    	    if (!nodeConnections.isEmpty()) {
    	        return false;
    	    }
    	}
    	
    	return true;
    	
    }
}