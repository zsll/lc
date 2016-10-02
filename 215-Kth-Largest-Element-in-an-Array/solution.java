public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int res = -1;
        if(nums != null && k > 0 && nums.length >= k) {
            int start = 0, end = nums.length - 1;
            while(start <= end) {
                int p = partition(nums, start, end);
                if(p + 1 == k) {
                    res = nums[p];
                    break;
                } else if(p + 1 > k) {
                    end = p - 1;
                } else {
                    start = p + 1;
                }
            }
        }
        return res;
    }
    
    int partition(int [] nums, int start, int end) {
        int t = nums[start];
        while(start < end) {
            while(start < end && t >= nums[end]) {
                end--;
            }
            if(start < end) {
                nums[start] = nums[end];
                start++;
            }
            while(start < end && t <= nums[start]) {
                start++;
            }
            if(start < end) {
                nums[end] = nums[start];
                end--;
            }
        }
        nums[start] = t;
        return start;
    }
}