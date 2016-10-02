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
    public boolean canAttendMeetings(Interval[] intervals) {
        boolean res = true;
        if(intervals != null && intervals.length > 0) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int preEnd = intervals[0].start;
        for(Interval i : intervals) {
            if(preEnd > i.start) {
                res = false;
                break;
            }
            preEnd = i.end;
        }
        }
        return res;
    }
}