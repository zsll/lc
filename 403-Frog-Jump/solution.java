public class Solution {
    /**
     * There are n minus 1 blocks
     * boolean dp[i][j] means it can reach i th stone with last step j, where j is smaller or equal to i
     * dp[i][j] = true if exist dp[k][j - 1], dp[k][j] ,dp[k][j + 1] is true and distance between ith and kth stone is j, where k is between 1 and i - 1
     * initialization: dp[0][0] = true, the jump actually starts from 1
     * dp[i][0] = false when i > 0
     * dp[1][1] = true if distance between stone 0 and 1 is 1
     * dp[1][i] = false where i > 1
     * 
     */
    public boolean canCross(int[] stones) {
        if(stones[1] > 1) return false;
        if(stones.length == 2) return true;
        return helper(stones, 1, 1);
    }
    private boolean helper(int[] arr, int i, int step){
        boolean pass = false;
        if(i == arr.length-1) return true;
        for(int j = i+1; j < arr.length; j++){
            if(arr[j] <= arr[i] + step + 1 && arr[j] >= arr[i]+step-1){
                pass = pass || helper(arr, j, arr[j] - arr[i]);
            }
        }
        return pass;
    }
}