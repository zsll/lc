public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        boolean res = false;
        if(nums != null && nums.length > 0 && k >= 0 && t >= 0) {
            SortedSet<Long> set = new TreeSet<Long>();
            for(int i = 0; i < nums.length; i++) {
                long left = (long)nums[i] - t, right = (long)nums[i] + t + 1;
                SortedSet<Long> sub = set.subSet(left, right);
                if(sub.size() > 0) {
                    res = true;
                    break;
                }
                set.add((long)nums[i]);
                if(i >= k) {
                    set.remove((long)nums[i - k]);
                }
            }
        }
        return res;
    }
}