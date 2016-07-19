public class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        if(nums != null && nums.length > 0) {
            int l = 0, r = nums.length - 1;
            while(l <= r) {
                int mid = l + (r - l >> 1);
                if(nums[mid] == target) {
                    res = mid;
                    break;
                }
                if (nums[mid] > nums[l] || nums[mid] > nums[r]) { //first part is sorted
                    if(nums[l] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else if (nums[mid] < nums[l] || nums[mid] < nums[r]) {  //second part is sorted
                    if(nums[mid] < target && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}