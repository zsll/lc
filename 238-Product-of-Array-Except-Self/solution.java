public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] res = nums;
        if(nums != null && nums.length > 0) {
            int len = nums.length;
            res = new int[len];
            int left = 1, right = 1;
            for(int i = 0; i < nums.length; i++) {
                  res[i] = 1;   //NoteNote
              }
            for(int i = 0; i < len; i++) {
                res[i] = left*res[i];
                res[len - i - 1] = right*res[len - i - 1];
                left *= nums[i];
                right *= nums[len - i - 1];
            }
        }
        return res;
    }
}