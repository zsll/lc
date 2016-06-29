public class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices != null && prices.length > 1) {
            int l = prices.length - 1;  //There are prices.length - 1 nubmers (diff between prices i minus prices minus 1
            //we need to find the max sum and make sure the minimum distance between adjacent diffs are larger than 1)
            int [] local = new int[l + 1];  //local i means max sum end with ith diff
            int [] global = new int[l + 1]; //global i means max sum end with any one, not has to be ith diff
            local[1] = prices[1] - prices[0];
            global[1] = Math.max(local[1], 0);
            if(prices.length > 2) {
                local[2] = Math.max(prices[2] - prices[1], prices[2] - prices[0]);
                global[2] = Math.max(local[2], global[1]);
                for(int i = 3; i <= l; i++) {
                    local[i] = Math.max(local[i - 1] + prices[i] - prices[i - 1], global[i-3] + prices[i] - prices[i - 1]);
                    global[i] = Math.max(local[i], global[i - 1]);
                }
            }
            res = global[l];
        }
        return res;
    }
}