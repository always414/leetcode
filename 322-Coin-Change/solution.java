public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
        	return 0;
        }
        
        return helper (coins, amount, new int[amount]);
    }
    
    private int helper (int[] coins, int remain, int[] count) {
    	if (remain < 0) {
    		return -1;
    	}
    	
    	if (remain == 0) {
    		return 0;
    	}
    	
    	if (count[remain-1] != 0) {
    		return count[remain-1];
    	}
    	int min = Integer.MAX_VALUE;
    	for (int coin : coins) {
    		int res = helper (coins, remain - coin, count);
    		// res = last amount result
    		
    		if (res >= 0 && res < min) {
    			min = res + 1; // ???
    		}
    	}
    	count[remain-1] = (min == Integer.MAX_VALUE)? -1: min;
    
    	return count[remain-1];
    }
}