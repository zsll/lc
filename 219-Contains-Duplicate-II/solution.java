public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean res = false;
        if(nums != null && nums.length > 1 && k > 0) {
            HashSet<Integer> h = new HashSet<Integer>();
            for(int i = 0; i < nums.length; i++) {
                if(h.contains(nums[i])) {
                    res = true;
                    break;
                } else {
                    h.add(nums[i]);
                    if(i >= k) {
                        h.remove(nums[i - k]);
                    }
                }
            }
        }
        return res;
    }
}