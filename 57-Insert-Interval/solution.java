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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals != null) {
            for(Interval i : intervals) {
                if(newInterval.end < i.start) {
                    res.add(newInterval);
                    newInterval = i;
                } else if(i.end < newInterval.start) {
                    res.add(i);
                 }  else {
                     newInterval.start = Math.min(newInterval.start, i.start);
                    newInterval.end = Math.max(newInterval.end, i.end);
                }
            }
            res.add(newInterval);
        }
        return res;
    }
}