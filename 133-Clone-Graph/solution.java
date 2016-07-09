import java.util.HashMap;
import java.util.Map;


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
	Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
    	
        if (!map.containsKey(node.label)) {
        	map.put(node.label, cloneNode);
        }
        
        for (UndirectedGraphNode neighbor : node.neighbors) {
        	cloneGraph(neighbor);
        	map.get(node.label).neighbors.add(map.get(neighbor.label));
        }
        
        return cloneNode;
    }
}