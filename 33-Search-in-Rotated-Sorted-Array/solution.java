public class Solution {
	public int search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (target == nums[mid]) {
				return mid;
			}
			
			if (nums[start] < nums[end]) {
				if (target < nums[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			} else {
				if (nums[mid] > nums[start]) {
					if (nums[start] <= target && target < nums[mid]) {
						end = mid;
					} else {
						System.out.println("heh");
						start = mid;
					}
				} else {
					if (nums[mid] < target && target <= nums[end]) {
						start = mid;
					} else {
						end = mid;
					}
				}
			}
		}
System.out.println(start + " " + end);
		return nums[start] == target ? start : nums[end] == target ? end : -1;

	}

}