public class Solution {
    public int integerBreak(int n) {
        int res = 1;
        if(n == 3) {
            res = 2;
        } else if (n > 3) {
            while(n > 4) {
                n -= 3;
                res *= 3;
            }
            res = res*n;
        }
        return res;
    }
}