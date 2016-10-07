public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums != null && nums.length > 0) {
            int i = 0;
            while(i < nums.length - 1) {
                if(i%2 == 0 && nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
                if(i%2 > 0 && nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }
    
    void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}