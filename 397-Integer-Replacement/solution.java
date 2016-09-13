public class Solution {
    public int integerReplacement(int n) {
        return (int)integerReplacementHelper((long)n);
    }
    
    public long integerReplacementHelper(long n) {
        if(n == 1) {
            return 0;
        }
        if(n%2 == 0) {
            return integerReplacementHelper(n/2) + 1;
        } else {
            return Math.min(integerReplacementHelper(n + 1), integerReplacementHelper(n - 1)) + 1;
        }
    }
}