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
            Interval m = intervals.get(0);
            for(int i = 1; i < intervals.size(); i++) {
                Interval n = intervals.get(i);
                if(m.end < n.start) {
                    res.add(m);
                    m = n;
                } else {
                    m.end = Math.max(m.end, n.end);
                }
            }
            res.add(m);
        }
        return res;
    }
}