public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int res = end + 1;
        if(nums[end] >= target) {
            while(start <= end) {
                int mid = (start + end)/2;
                if(nums[mid] >= target) {
                    res = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return res;
    }
}