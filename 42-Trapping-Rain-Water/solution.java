public class Solution {
	public int trap(int[] height) {
		int highestPoint = 0;
		int h = 0;
		int water = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] < h)
				continue;
			h = height[i];
			highestPoint = i;
		}

		int left = 0;
		for (int i = 0; i < highestPoint; i++) {
			if (height[i] < left) {
				water += (left - height[i]);
			} else {
				left = height[i];
			}
		}
		int right = 0;
		for (int i = height.length - 1; i > highestPoint; i--) {
			if (height[i] < right) {
				water += (right - height[i]);
			} else {
				right = height[i];
			}
		}

		return water;
	}
}