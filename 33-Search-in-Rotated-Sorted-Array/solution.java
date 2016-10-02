public class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        if(nums != null && nums.length > 0) {
            int start = 0, end = nums.length - 1;
            while(start <= end) {
                int mid = start + (end - start >> 1);
                if(nums[mid] == target) {
                    res = mid;
                    break;
                }
                if(nums[start] <= nums[mid] || nums[mid] > nums[end]) {
                    if(nums[start] <= target && nums[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else if(nums[mid] <= nums[end] || nums[start] > nums[mid]) {
                    if(nums[end] >= target && nums[mid] < target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    start++;
                    end--;
                }
            }
        }
        return res;
    }
}