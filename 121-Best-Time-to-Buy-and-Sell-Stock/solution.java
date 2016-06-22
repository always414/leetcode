public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
        	return 0;
        }
        
        int buy = 0;
        int profit = 0;
        
        // i means the current date
        for (int i = 1; i < prices.length; i ++) {
        	if (prices[i - 1] < prices[buy]) {
        		buy = i - 1; // update buy date
        	}
        	profit = Math.max(profit, prices[i] - prices[buy]);
        }

        return profit;
    }
}