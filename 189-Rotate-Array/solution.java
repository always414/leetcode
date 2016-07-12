import java.util.Arrays;

public class Solution {
	public void rotate(int[] nums, int k) {
		if (k == 0 || nums.length == 1 || nums.length == 0) return;
		int n = nums.length;
		int index = 0;
		int prev = nums[index];
		int startIndex = index;
		int count = 1;
		
		while (count <= n ) {
			int temp = nums[(index + k) % n];
			nums[(index + k) % n] = prev;
			prev = temp;
			index = (index + k) % n;
			count ++;
			
			if (index == startIndex) {
				index = (index + 1) % n;
				startIndex = index;
				prev = nums[index];
			}
		}

	}
}