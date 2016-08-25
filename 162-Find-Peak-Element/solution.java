public class Solution {
    public int findPeakElement(int[] nums) {
        int res = -1;
        if(nums != null && nums.length > 0) {
            res = 0;
            int start = 0, end = nums.length - 1;
            while(start <= end) {
                int mid = start + end >> 1;
                int trend = isPeak(nums, mid);
                if(trend == 0) {
                    res = mid;
                    break;
                } else if (trend == 1) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return res;
    }
    
    int isPeak(int [] a, int i) {
        if(biggerThanNext(a, i) && biggerThanPre(a, i)) {
            return 0;
        } else if(biggerThanPre(a, i)) {
            return 1;
        } else {
            return -1;
        }
    }
    
    boolean biggerThanNext(int [] a, int i) {
    	return i == a.length - 1 || a[i] > a[i + 1];
    }
    
    boolean biggerThanPre(int [] a, int i) {
    	return i == 0 || a[i] > a[i - 1];
    }
}