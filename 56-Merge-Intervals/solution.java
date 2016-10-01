/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals != null && intervals.size() > 0) {
            Collections.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval a, Interval b) {
                    return a.start - b.start;
                }
            });
            Interval pre = intervals.get(0);
            for(int i = 1; i < intervals.size(); i++) {
                Interval cur = intervals.get(i);
                if(pre.end < cur.start) {
                    res.add(pre);
                    pre = cur;
                } else {
                    /*
                    Submission Result: Wrong Answer More Details 

Input:
[[1,4],[2,3]]
Output:
[[1,3]]
Expected:
[[1,4]]*/
                    pre.end = Math.max(pre.end,cur.end);
                }
            }
            res.add(pre);
        }
        return res;
    }
}