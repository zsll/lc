public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        boolean res = false;
        if(nums != null && nums.length > 1 && k > 0 && t >= 0) {
            SortedSet<Long> m = new TreeSet<Long>();
            for(int i = 0; i < nums.length ; i++) {
                SortedSet<Long> sub = m.subSet(((long)nums[i] - t), ((long)nums[i] + t + 1));   //Needs to convert firstly, then +/- t
                if(sub.size() > 0) {
                    res = true;
                    break;
                }
                m.add((long)nums[i]);
                if(i >= k) {
                    m.remove((long)nums[i - k]);
                }
            }
        }
        return res;
    }
}