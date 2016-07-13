import java.util.Arrays;

public class NumArray {
	private int[] sums;
	private int[] nums;

	public NumArray(int[] nums) {
//		O(n) initialize
        sums = new int[nums.length];
	    this.nums = nums;
	    if (nums.length > 0) {
    	    sums[0] = nums[0];
    		for (int i=1;i<nums.length;i++) {
    	        sums[i] = sums[i-1] + nums[i];
    		}
	    }
    }
	
    public void update (int i, int val) {
        if (i >= sums.length) return;
		int diff = val - nums[i];
		nums[i] = val;
		for (int x = i; x < sums.length; x++) {
		    sums[x] += diff;
		}
	}
	
    public int sumRange(int i, int j) {
    	if ( i == 0 ) return sums[j];
    	
        return sums[j] - sums[i-1];
    }
}
//[7,2,7,2,0]
//--> 

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);