import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> sub = new ArrayList<>();
		for (int i : nums) {
			sub.add(i);
		}
		permuteHelper(res, sub, 0);
		return new ArrayList<>(res);
	}

	private void permuteHelper(List<List<Integer>> result, List<Integer> sub, int start) {
		if (start > sub.size())
			return;

		if (start == sub.size()) {
			result.add(new ArrayList<>(sub));
			return;
		}
		Set<Integer> swp = new HashSet<>();
		
		for (int i = start; i < sub.size(); i++) {
			if (swp.contains(sub.get(i))) continue;
			swp.add(sub.get(i));
			Collections.swap(sub, start, i);
			permuteHelper(result, sub, start + 1);
			Collections.swap(sub, start, i);
		}
	}
}