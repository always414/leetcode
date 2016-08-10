import java.util.*;

public class Solution {
	List<List<String>> result = new ArrayList<>();

	public List<String> findItinerary(String[][] tickets) {
		Map<String, List<String>> map = new HashMap<>();
		for (String[] ticket : tickets) {
			if (!map.containsKey(ticket[0])) {
				map.put(ticket[0], new ArrayList<>(Arrays.asList(ticket[1])));
			} else {
				map.get(ticket[0]).add(ticket[1]);
			}
		}

		dfs(map, "JFK", new ArrayList<>(Arrays.asList("JFK")));
		
		return result.get(0);

	}

	private void dfs(Map<String, List<String>> map, String airport, List<String> itinerary) {
		if (map.isEmpty()) {
			result.add(new ArrayList<>(itinerary));
			return;
		}

		if (!map.containsKey(airport)) {
			return;
		}

		List<String> destinations = map.get(airport);
		if (destinations.size() == 1) {
			map.remove(airport);
			itinerary.add(destinations.get(0));
			dfs(map, destinations.get(0), itinerary);
			itinerary.remove(itinerary.size() - 1);
			map.put(airport, destinations);
		} else {
			Collections.sort(destinations);
			// try every destination from small to large
			for (int i = 0; i < destinations.size(); i++) {
				String to = destinations.remove(i);
				itinerary.add(to);
				dfs(map, to, itinerary);
				itinerary.remove(itinerary.size() - 1);
				destinations.add(i, to);
			}
		}
		
	}

}