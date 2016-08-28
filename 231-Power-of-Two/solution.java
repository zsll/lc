public class Solution {
    public boolean isPowerOfTwo(int n) {
        boolean res = false;
        if(n > 0) {
            while(n > 1) {
                if((n&1) == 1) {
                    break;
                }
                n = n>>1;
            }
            res = n == 1;
        }
        return res;
    }
}