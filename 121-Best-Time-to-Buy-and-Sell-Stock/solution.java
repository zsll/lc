public class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices != null && prices.length > 1) {
            int min = prices[0];
            for(int i = 1; i < prices.length; i++) {
                res = Math.max(res, prices[i] - min);
                min = Math.min(min, prices[i]);
            }
        }
        return res;
    }
}