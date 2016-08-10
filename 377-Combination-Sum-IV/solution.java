import java.util.Arrays;

public class Solution {
	//recursion depth too large
	//try dp
	public int combinationSum4(int[] nums, int target) {
		
		int[] dp = new int[target + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i == nums[j]) {
					dp[i] ++;
				} else if (i - nums[j] > 0) {
					dp[i] += dp[i - nums[j]];
				}
			}
		}
		return dp[target];
	}

	


}