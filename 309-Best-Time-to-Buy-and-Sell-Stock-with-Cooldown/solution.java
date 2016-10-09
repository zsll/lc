public class Solution {
    // convert the price diff to blocks, diff i = price[i + 1] - price[i]
    // sell, rest, buy, sell i = diff i - 1 + 
    //s[i] is the profit of selling on i th dy (must take the i th block), g[i] is the global max on day i
    //s[i] = Math.max(s[i - 1] + diff[i - 1], g[i - 3] + diff[i - 1])
    //g[i] = Math.max(g[i - 1], s[i]);
    //initialization:
    //s 0 = 0, g 0 = 0,
    //s 1 = diff 0, g 1 = Math.max(0, s1)
    //s 2 = Math.max(diff 1, diff 0 + diff 1), g 2 = Math.max(g 1, s 2)
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices != null && prices.length > 1) {   //at least there is 1 block
            int len = prices.length;
            int [] diff = new int[len - 1];
            for(int i = 0; i < len - 1; i++) {
                diff[i] = prices[i + 1] - prices[i];
            }
            int [] s = new int[len - 1 + 1];    //profit of taking i th
            int [] g = new int[len - 1 + 1];    //global for first i diff
            s[1] = diff[0];
            g[1] = Math.max(0, s[1]);
            if(len > 2) {
                s[2] = Math.max(diff[0], 0) + diff[1];
                g[2] = Math.max(g[1], s[2]);
                for(int i = 3; i < len; i++) {
                    s[i] = Math.max(s[i - 1] + diff[i - 1], g[i - 3] + diff[i - 1]);
                    g[i] = Math.max(g[i - 1], s[i]);
                }
            }
            res = g[len - 1];
        }
        return res;
    }
}