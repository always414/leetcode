import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums); // nlogn
		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < nums.length - 2; i++) {
			Set<Integer> set = new HashSet<>();
			for (int k = nums.length - 1; k > i; k--) {
				if (set.contains(nums[k])) {
					if (!res.contains(Arrays.asList(nums[i], nums[k], 0 - nums[i] - nums[k]))) {
						res.add(Arrays.asList(nums[i], nums[k], 0 - nums[i] - nums[k]));
					}
					set.remove(nums[k]);
				} else {
					int target = 0 - nums[i] - nums[k];
					set.add(target);
				}
			}
		}
		return res;
	}
}