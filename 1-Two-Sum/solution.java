public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] res = {-1, -1};
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        if(nums != null && nums.length > 1) {
            m.put(nums[0], 0);
            for(int i = 1; i < nums.length; i++) {
                if(m.containsKey(target - nums[i])) {
                    res[0] = m.get(target - nums[i]);
                    res[1] = i;
                    break;
                }
                m.put(nums[i], i);
            }
        }
        return res;
    }
}