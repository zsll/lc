public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int res = 1;
        
        if(n > 0) {
            int [] f = new int[n + 1];
            f[1] = 10;  //only 1 digit
            res = f[1];
            if(n > 1) {
                f[2] = 9 * 9;   //from 10 to 99
                res += f[2];
                //f[3] from 100 to 999, 9*9*8
                //if n = 10, not possible
                for(int i = 3; i <= Math.min(n, 9); i++) {
                    f[i] = f[i - 1]*(11 - i);
                    res += f[i];
                }
            }
        }
        return res;
    }
}