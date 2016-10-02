public class Solution {
    public int mySqrt(int x) {
        long res = 0;
        if(x >= 1) {
            long start = 1, end = x;
            while(start <= end) {
                long mid = (long)((end - start >> 1) + start);
                if(mid*mid == x) {
                    res = mid;
                    break;
                } else if (mid*mid > x) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            //now start > end
            if(res == 0) {//NoteNote, not found
                res = start;
                if(start*start > x) {
                    res = end;
                }
            }
        }
        return (int)res;
    }
}