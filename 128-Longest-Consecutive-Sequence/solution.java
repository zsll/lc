public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        if(nums != null && nums.length > 0) {
            HashSet<Integer> s = new HashSet<Integer>();
            for(int i : nums) {
                s.add(i);
            }
            for(int i : nums) {
                if(s.contains(i)) {
                    s.remove(i);
                    int inc = 1, dec = 1;
                    while(s.contains(i + inc)) {
                        s.remove(i + inc);
                        inc++;
                    }
                    while(s.contains(i - dec)) {
                        s.remove(i - dec);
                        dec++;
                    }
                    res = Math.max(res, dec + inc - 1);
                }
            }
        }
        return res;
    }
}