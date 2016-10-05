public class Solution {
    public boolean isPerfectSquare(int num) {
        boolean res = false;
        if(num >= 0) {
            long start = 0L, end = (long)num;
            while(start <= end) {
                long mid = start + (end - start >> 1);
                long product = mid*mid;
                if(product == (long)num) {
                    res = true;
                    break;
                }
                if(product < (long)num) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return res;
    }
}