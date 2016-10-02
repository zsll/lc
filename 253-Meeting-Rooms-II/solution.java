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
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        PriorityQueue<Integer> endQ = new PriorityQueue<Integer>();
        for(Interval i : intervals) {
            if(!endQ.isEmpty() && i.start >= endQ.peek()) {  //NoteNote: is empty, else how to peek
                endQ.poll();
            }
            endQ.offer(i.end);
        }
        return endQ.size();
    }
}