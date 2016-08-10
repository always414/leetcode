import java.util.*;

public class Solution {
    Map<String, PriorityQueue<String>> flights;
    ArrayList<String> itinerary;

	public List<String> findItinerary(String[][] tickets) {
	    flights = new HashMap<>();
	    itinerary = new ArrayList<String>();
	    
	    for (String[] ticket : tickets) {
	        flights.putIfAbsent(ticket[0], new PriorityQueue<String>());
	        flights.get(ticket[0]).add(ticket[1]);
	    }
	
		dfs("JFK");
		return itinerary;
	}

	private void dfs(String departure){
	    PriorityQueue<String> arrivals = flights.get(departure);
	
    	while (arrivals != null && !arrivals.isEmpty()) {
    	    dfs(arrivals.poll());
    	}
		//when add to itinerary, departure has no arrivals
		//倒序插入
		itinerary.add(0, departure);
	}

}