import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	public boolean canMeasureWater(int x, int y, int z) {
		Set<Integer> set = new HashSet<>();
		set.addAll(Arrays.asList(x, y, x + y));
		int newX = x;
		
		while (newX > 0) {
			int mod = newX % y;
			set.add(mod);
			set.add(0 - mod);
			newX = newX - (y - mod);
		}
		
		newX = x;
		while (newX - y > 0) {
			set.add(newX - y);
			set.add(y - newX);
			newX -= y;
		}

		set.add(newX - y);
		set.add(y - newX);

		List<Integer> array = new ArrayList<>(set);
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.size(); j++) {
				if (array.get(i) + array.get(j) == z) {
					return true;
				}
			}
		}

		return false;
	}
}