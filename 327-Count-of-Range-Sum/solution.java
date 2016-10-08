public class Solution {
    //Subarray Sum II in lintcode
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        if(nums != null && nums.length > 0 && lower <= upper) {
            int len = nums.length;
            int [] sum = new int[len + 1];
            for(int i = 0; i < len; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
            for(int i = 1; i <= len; i++) {
                //sum i - sum j >= lower, sum i - sum j <= upper, where j is smaller than i
                //sum j <= sum i - lower, sum j >= sum i - upper
                //since sum is sorted, can use binary search
                //sum j <= sum i - lower is equivalent to find first index that sum j >= sum i - lower + 1, then minus 1
                int l = firstGTET(sum, i - 1, sum[i] - upper), r = firstGTET(sum, i - 1, sum[i] - lower + 1);
                res += (r - l);
            }
        }
        return res;
    }
    
    public int firstGTET(int [] sum, int end, int target) {
        int start = 0;
        while(start <= end) {
            int mid = start + (end - start >> 1);
            if(sum[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}