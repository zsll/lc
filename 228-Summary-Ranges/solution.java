public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums != null && nums.length > 0) {
            int start = nums[0], end = nums[0] - 1;
            for(int i : nums) {
                if(end < i - 1) {
                    res.add(getS(start, end));
                    start = i;
                }
                end = i;
            }
            res.add(getS(start, end));
        }
        return res;
    }
    
    String getS(long start, long end) {
        if(start == end) {
            return Long.toString(start);
        } else {
            return start + "->" + end;
        }
    }
}