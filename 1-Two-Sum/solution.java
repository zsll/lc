public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums != null && nums.length > 1) {
            HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
            for(int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                if(h.containsKey(target - cur)) {
                    res[0] = h.get(target - cur);
                    res[1] = i;
                    break;
                }
                h.put(cur, i);
            }
        }
        return res;
    }
}