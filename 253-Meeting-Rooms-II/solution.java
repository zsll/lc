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
    public int minMeetingRooms(Interval[] intervals) {
        int res = 0;
        if(intervals != null && intervals.length > 0) {
            Arrays.sort(intervals, new Comparator<Interval>() {
              public int compare(Interval a, Interval b) {
                  return a.start - b.start;
              }  
            });
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            for(Interval i : intervals) {
                if(!pq.isEmpty() && pq.peek() <= i.start) {
                    pq.poll();
                }
                pq.offer(i.end);
            }
            res = pq.size();
        }
        return res;
    }
}