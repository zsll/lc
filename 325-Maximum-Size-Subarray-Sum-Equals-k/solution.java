public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0;
        if(nums != null && nums.length > 0) {
            HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
            int sum = 0;
            h.put(sum, 0);
            for(int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if(h.containsKey(sum - k)) {
                    res = Math.max(res, i + 1 - h.get(sum - k));
                }
                if(!h.containsKey(sum)) {
                    h.put(sum, i + 1);
                }
            }
        }
        return res;
    }
}