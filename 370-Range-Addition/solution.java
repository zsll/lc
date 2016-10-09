public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int [] res = new int[length];
        for(int [] u : updates) {
            int start = u[0], end = u[1] + 1, diff = u[2];
            res[start] += diff;
            if(end < length) {
                res[end] -= diff;
            }
        }
        for(int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}