public class Solution {
    public boolean isPerfectSquare(int num) {
        boolean res = false;
        if(num >= 1) {
            int low = 1, high = num;
            while(low <= high) {
                int mid = low + (high - low >> 1);
                if(mid*mid == num) {
                    res = true;
                    break;
                } else if (mid*mid > num) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return res;
    }
}