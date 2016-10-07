public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums != null && nums.length > 1) {
            int high = nums.length - 2;
            while(high >= 0 && nums[high] >= nums[high + 1]) {
                high--;
            }
            if(high != -1) { 
                int toSwapDigit = findFirstLargerThan(nums, high + 1, nums[high]);
                int temp = nums[high];
                nums[high] = nums[toSwapDigit];
                nums[toSwapDigit] = temp;
            }
            swap(nums, high + 1, nums.length - 1);
        }
    }
    
    /**
     * from i to nums.length - 1 is descending, user bs
     */ 
    int findFirstLargerThan(int [] nums, int i, int target) {
        int j = nums.length - 1;
        while(i <= j) {
            int mid = i + (j - i >> 1);
            if(nums[mid] > target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return j;
    }
    
    void swap(int [] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}