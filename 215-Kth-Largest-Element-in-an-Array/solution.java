import java.util.Arrays;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
    	int n = nums.length;
    	int p = quickSelect(nums, 0, n - 1, k);
    	return p;
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
    	int leftPtr = left - 1;
    	int rightPtr = right;
    	
    	int pivot = nums[right];
    	
    	while (leftPtr < rightPtr) {
    		if (nums[leftPtr++] > pivot) {
    			swap(nums, --leftPtr, --rightPtr);
    		}
    	}
    	
    	int m = leftPtr - left + 1;
    	
    	if (m == k) return leftPtr;
    	else if (m > k) return quickSelect(nums, left, leftPtr - 1, k);
    	else return quickSelect(nums, leftPtr + 1, right, k - m);
    	
    }
    
    private void swap(int[] nums, int a, int b) {
    	int c = nums[a];
    	nums[a] = nums[b];
    	nums[b] = c;
    }
}