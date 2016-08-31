public class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null) {
            return 0;
        }
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        for(int i : nums) {
            l.add(i);
        }
        l.add(1);
        int len = l.size();
        int [][] dp = new int[len][len];
        for(int diff = 2; diff < len; diff++) { //diff between i and j
            for(int i = 0; i + diff < len; i++) {
                int j = diff + i;
                for(int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + l.get(i)*l.get(k)*l.get(j));
                }
            }
        }
        return dp[0][len - 1];
    }
}