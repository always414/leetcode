public class Solution {
	public boolean search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {

			//去重
			while (start + 1 < end && nums[start] == nums[start + 1]) {
				start ++;
			}
			
			while (start + 1 < end && nums[end] == nums[end - 1]) {
				end --;
			}
			//去尾
			if (nums[start] == nums[end]) {
				end -= 1;
			}
			
			if (start + 1 == end) {
				return nums[start] == target || nums[end] == target;
			}
			
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[start]) {
				if (nums[start] <= target && target <= nums[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			} else {
//				System.out.println(start + " " + mid + " "  + end);
				if (nums[mid] <= target && target <= nums[end]) {
					start = mid;
				} else {
					end = mid;
				}
			}
		}
		return nums[start] == target || nums[end] == target;
	}

}