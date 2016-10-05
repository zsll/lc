public class Solution {
    public int minCost(int[][] costs) {
        int res = 0;
        if(costs != null && costs.length > 0) {
            int len = costs.length;
            for(int i = 1; i < len; i++) {
                for(int j = 0; j < 3; j++) {
                    costs[i][j] += Math.min(costs[i - 1][(j + 1)%3], costs[i - 1][(j + 2)%3]);
                }
            }
            res = Integer.MAX_VALUE;
            for(int i = 0; i < 3; i++) {
                res = Math.min(res, costs[len - 1][i]);
            }
        }
        return res;
    }
}