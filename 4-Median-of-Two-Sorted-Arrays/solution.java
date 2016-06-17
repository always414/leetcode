public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] num = merge(nums1, nums2);
		int length = num.length;
		if (length % 2 == 0) {
			return (num[length/2] + num[length/2 + 1])/2;
		} else {
			return num[(length / 2 + 1)];
		}
	}

	private int[] merge(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0) {
			return nums2;
		}
		
		if (nums2 == null || nums2.length == 0) {
			return nums1;
		}
		int[] num = new int[nums1.length + nums2.length];
		int i = 0, j = 0, k = 0;

		while (k < num.length) {
			if (i == nums1.length && j < nums2.length) {
				num[k++] = nums2[j++];
			} else if (j == nums2.length && i < nums1.length) {
				num[k++] = nums1[i++];
			} else if (i < nums1.length && j < nums2.length) {
				if (nums1[i] <= nums2[j]) {
					num[k++] = nums1[i++];
				} else {
					num[k++] = nums2[j++];
				}
			} else {
				break;
			}
		}
		return num;
	}

}