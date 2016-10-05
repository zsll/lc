public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = findFirstLargerThanOrEuqalToFromLeft(nums, target);
        int endPlus1 = findFirstLargerThanOrEuqalToFromLeft(nums, target + 1);
        int [] res = {-1, -1};
        if(start < endPlus1) { 
            res[0] = start;
            res[1] = endPlus1 - 1;
        }
        return res;
    }
    
    int findFirstLargerThanOrEuqalToFromLeft(int [] a, int t) {
        int start = 0, end = a.length - 1;
        while(start <= end) {
            int mid = start + (end - start >> 1);
            if(a[mid] >= t) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}