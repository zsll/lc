public class Solution {
    public int findPeakElement(int[] nums) {
        int res = -1;
        if(nums != null && nums.length > 0) {
            int i = 0, j = nums.length - 1;
            while(i <= j) {
                int mid = i + (j - i >> 1);
                boolean gtp = largerThanPre(nums, mid), gtn = largerThanNext(nums, mid);
                if(gtp && gtn) {
                    res = mid;
                    break;
                } else if (gtp) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return res;
    }
    
    boolean largerThanPre(int [] nums, int i) {
        return i == 0 || nums[i] > nums[i - 1];
    }
    
    boolean largerThanNext(int [] nums, int i) {
        return i == nums.length - 1 || nums[i] > nums[i + 1];
    }
}