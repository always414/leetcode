import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();

		if (nums == null)
			return res;
		
		if (nums.length == 0) {
			res.add(lower + "->" + upper);
		}

		for (int i = 0; i <= nums.length ; i++) {
			StringBuilder sb = new StringBuilder();
			int lowerbound = Integer.MAX_VALUE;
			int upperbound = Integer.MIN_VALUE;
			if (i == 0) {
				lowerbound = lower;
				upperbound = nums[i] - 1;
			} else if (i == nums.length) {
				lowerbound = nums[i-1] + 1;
				upperbound = upper;
			} else {
				lowerbound = nums[i - 1] + 1;
				upperbound = nums[i] - 1;
			}

			if (lowerbound < upperbound) {
				sb.append(lowerbound).append("->").append(upperbound);
			} else if (lowerbound == upperbound) {
				sb.append(lowerbound);
			}

//			System.out.println(nums[i] + " " + sb.toString());
			if (sb.length() != 0) {
				res.add(sb.toString());
			}
		}

		return res;
	}
}