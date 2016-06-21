public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums;
		
		if (nums1 == null || nums1.length == 0) {
			nums = nums2;
		} else if (nums2 == null || nums2.length == 0) {
			nums = nums1;
		} else {
			nums = new int[nums1.length + nums2.length];
		}
		
		int i = 0, j = 0, k = 0 ;
		while (k < nums.length) {
			if (i == nums1.length && j < nums2.length) {
				nums[k ++] = nums2[j ++];
			} else if (j == nums2.length && i < nums1.length) {
				nums[k ++] = nums1[i++];
			} else if ( i == nums1.length && j == nums2.length) {
				break;
			} else {
				if (nums1[i] <= nums2[j]) {
					nums[k++] = nums1[i++];
				} else {
					nums[k++] = nums2[j++];
				}
			}
		}
		
		if (nums== null || nums.length == 0) {
			throw new IllegalArgumentException("Invalid input. No solution!");
		}
		
		if (nums.length % 2 == 0) {
			return (nums[nums.length / 2] + nums[(nums.length-1) / 2]) / (2.0);
		} else {
			return nums[(nums.length-1) / 2];
		}
	}
}