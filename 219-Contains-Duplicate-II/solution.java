public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean res = false;
        if(nums != null && nums.length > 1 && k > 0) {
            HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
            for(int i = 0; i < nums.length; i++) {
                if(h.containsKey(nums[i]) && i - h.get(nums[i]) <= k) {
                    res = true;
                    break;
                } else {
                    h.put(nums[i], i);
                }
            }
        }
        return res;
    }
}