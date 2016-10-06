public class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean res = false;
        if(nums != null && nums.length > 1) {
            HashSet<Integer> s = new HashSet<Integer>();
            for(int i : nums) {
                if(s.contains(i)) {
                    res = true;
                    break;
                }
                s.add(i);
            }
        }
        return res;
    }
}