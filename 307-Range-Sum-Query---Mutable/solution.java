public class NumArray {
	private int st[];
	private int[] nums;
    public NumArray(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int maxSize = 2 * (int) Math.pow(2, x) - 1;
        st = new int[maxSize];
        constructSTUtil(nums, 0, n-1, 0);
    }

    int constructSTUtil(int nums[], int ss, int se, int si) {
    	if (ss == se) {
    		st[si] = nums[ss];
    		return nums[ss];
    	}
    	
    	int mid = getMid(ss, se);
    	
    	st[si] = constructSTUtil(nums, ss, mid, si * 2 + 1) + constructSTUtil(nums, mid + 1, se, si * 2 + 2);
    	return st[si];
    }
    
    
    private int getMid(int ss, int se) {
		return ss + (se - ss) / 2;
	}

	void update(int i, int val) {
        if (i < 0 || i > nums.length - 1) {
        	return;
        }
        
        int diff = val - nums[i];
        updateValueUntil(0, nums.length - 1, i, diff, 0);
    }

    private void updateValueUntil(int ss, int se, int i, int diff, int si) {
    	if (i < ss || i > se)
    		return;
    	
    	st[si] = st[si] + diff;
    	if (se != ss) {
    		int mid = getMid(ss, se);
    		updateValueUntil(ss, mid, i, diff, 2 * si + 1);
    		updateValueUntil(mid + 1, se, i, diff, 2*si + 2);
    	}
	}

	public int sumRange(int i, int j) {
        if (i < 0 || j > nums.length - 1 || i > j) {
        	return -1;
        }
        
        return getSumUntil(0, nums.length-1, i , j, 0);
    }

	private int getSumUntil(int ss, int se, int i, int j, int si) {

		if (i <= ss && j >= se) {
			return st[si]; //?
		}
		
		if (se < i || ss > j) {
			return 0;
		}
		
		int mid = getMid(ss, se);
		return getSumUntil(ss, mid, i, j, 2 * si + 1) + getSumUntil(mid + 1, se, i, j, 2 * si + 1);
	}
}



// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);