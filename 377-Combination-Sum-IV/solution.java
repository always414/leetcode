public class Solution {
	private int count = 0;

	public int combinationSum4(int[] nums, int target) {
		helper(nums, target);
		return count;
	}

	private void helper(int[] nums, int target) {
		if (target < 0) {
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (target == nums[i]) {
				count ++;
			} else if (target - nums[i] > 0){
				helper(nums, target - nums[i]);
			}
		}
	}

}