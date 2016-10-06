public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        long pre = lower - 1;
        for(int i = 0; i < nums.length; i++) {
            if((long)nums[i] > (long)pre + 1) {
                res.add(getS((long)pre + 1, (long)nums[i] - 1));
            }
            pre = (long)nums[i];
        }
        if((long)upper >= (long)pre + 1) {
            /**We need the equal sign
             * Submission Result: Wrong Answer More Details 

Input:
[]
1
1
Output:
[]
Expected:
["1"]*/
            res.add(getS((long)pre + 1, (long)upper));
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