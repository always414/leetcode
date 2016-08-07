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
			//fix i and two pointer for the rest;
			if (i == 0 || i > 0 && nums[i] != nums[i-1]) {
				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
				while (lo < hi) {
					System.out.println(lo + " " + hi);
					if (nums[lo] + nums[hi] == sum) {
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while (lo < hi && nums[lo] == nums[lo+1]) lo ++;
						while (lo < hi && nums[hi] == nums[hi-1]) hi --;
						lo ++;
						hi --;
					} else if (nums[lo] + nums[hi] < sum) {
						lo ++;
					} else {
						hi --;
					}
				}
			}
		}
		return res;
	}
}