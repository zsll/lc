/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    TreeMap<Integer, Interval> m = new TreeMap<Integer, Interval>();
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        
    }
    
    public void addNum(int val) {
        if(m.containsKey(val)) return;  //NoteNote, else it's may overwrite m.get(val)
        Integer pre = m.lowerKey(val), next = m.higherKey(val);
        if(pre != null && m.get(pre).end >= val) {
            return;
        } else {
            if(pre != null && next != null && m.get(pre).end == val - 1 && val == next - 1) {
                Interval cur = m.remove(next);
                m.get(pre).end = cur.end;
            } else if (pre != null && m.get(pre).end == val - 1) {
                m.get(pre).end = val;
            } else if (next != null && val == next - 1) {
                Interval cur = m.remove(next);
                cur.start = val;
                m.put(val, cur);
            } else {
                m.put(val, new Interval(val, val));
            }
        }
    }
    
    public List<Interval> getIntervals() {
        List<Interval> res = new ArrayList<Interval>();
        for(Map.Entry<Integer, Interval> e : m.entrySet()) {
            res.add(e.getValue());
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */