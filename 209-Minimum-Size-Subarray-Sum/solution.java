public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        if(nums != null && nums.length > 0 && s > 0) {
            TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();
            
            m.put(0, 0);
            int sum = nums[0];
            m.put(sum, 1);
            if(sum >= s) {
                res = 1;
            } else {
                for(int i  = 1; i < nums.length; i++) {
                    sum += nums[i];
                    //sum - preSum >= s
                    Integer preSum = m.lowerKey(sum - s + 1);
                    if(preSum != null) {
                        int preIndex = m.get(preSum);
                        res = Math.min(i + 1 - preIndex, res);
                    }
                    m.put(sum, i + 1);
                }
            }
        }
        
            if(res == Integer.MAX_VALUE) {  //NoteNote
                res = 0;
            }
        return res;
    }
}