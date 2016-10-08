

public class Solution {
    //Subarray Sum II in lintcode
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        if(nums != null && nums.length > 0 && lower <= upper) {
            TreeMap<Long, Integer> m = new TreeMap<Long, Integer>();  //key is sum, value is frequency
            long sum = 0;
            m.put(sum, 1);
            for(int i = 0; i < nums.length; i++) {
                sum += nums[i];
                //sum - pre >= lower, pre <= sum - lower; sum - pre <= upper, pre >= sum - upper
                //SortedMap<Integer, Integer> sub = m.subMap(sum - upper, sum - lower + 1);
                for(Map.Entry<Long, Integer> e : m.subMap(sum - upper, sum - lower + 1).entrySet()) {
                    res += e.getValue();
                }
                if(!m.containsKey(sum)) {
                    m.put(sum, 0);
                }
                int pre = m.get(sum);
                m.put(sum, pre + 1);
            }
        }
        return res;
    }
}