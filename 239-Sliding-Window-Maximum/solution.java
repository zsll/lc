public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] res = {};
        if(nums != null && k > 0 && nums.length >= k) {
            int resLen = nums.length - k + 1, len = nums.length;
            res = new int[resLen];
            LinkedList<Integer> deq = new LinkedList<Integer>();
            for(int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                while(deq.size() > 0 && deq.get(deq.size() - 1) < cur) {
                    deq.removeLast();
                }
                deq.add(cur);
                if(i + 1 >= k) {    //NoteNote the plus 1
                    res[i - k + 1] = deq.get(0);    //it's descending in deq
                    if(deq.get(0) == nums[i - k + 1]) {
                        deq.remove(0);
                    }
                }
            }
        }
        return res;
    }
}