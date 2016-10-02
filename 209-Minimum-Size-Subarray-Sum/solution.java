public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        if(nums != null && nums.length > 0 && s > 0) {
           int sum = 0, j = 0;
           for(int i = 0; i < nums.length; i++) {
               while(j < nums.length && sum < s) {
                   sum += nums[j];
                   j++;
               }
               if(sum >= s) {
                   res = Math.min(res, j - i);
               }
               sum -= nums[i];
           }
        }
        
            if(res == Integer.MAX_VALUE) {  //NoteNote
                res = 0;
            }
        return res;
    }
}