 import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        } 
    	//matrix represents the max profit on i-th day
    	int[] profit = new int[prices.length + 1];
    	profit[0] = 0;
    	profit[1] = 0;
    	
    	for (int i = 2; i < profit.length; i++) {
    		for (int j = i-1; j > 0; j--) {
    			if (j < 2) {
    				profit[i] = Math.max(profit[i], Math.max(profit[i-1], prices[i-1] - prices[j-1]));
    			} else {
    				profit[i] = Math.max(profit[i], Math.max(profit[i-1], prices[i-1] - prices[j-1] + profit[j-2]));
    			}
    		}
    	}
    	return profit[prices.length];

    }
}