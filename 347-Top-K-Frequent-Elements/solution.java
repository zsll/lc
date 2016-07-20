public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for(int i : nums) {
            if(!h.containsKey(i)) {//NoteNote: containsKey
                h.put(i, 0);
            }
            int count = h.get(i);
            h.put(i, count + 1);
        }
        List<IntCount> l = new ArrayList<IntCount>();
        for(int i : h.keySet()) {
            l.add(new IntCount(i, h.get(i)));
        }
        PriorityQueue<IntCount> q = new PriorityQueue<IntCount>(k, new Comparator<IntCount>() {   //NoteNote, initial size
           //@Override
           public int compare(IntCount a, IntCount b) { //NoteNote, no override, needs public
               return Integer.compare(a.count, b.count);
           }
        });
        List<Integer> res = new ArrayList<Integer>();
        for(IntCount ic : l) {
            if(q.size() < k || ic.count > q.peek().count) {
                q.offer(ic);
                if(q.size() > k) {
                    q.poll();
                }
            }
        }
        while(q.size() > 0 ) {
            res.add(q.poll().val);
        }
        return res;
    }
    
    class IntCount {
        public IntCount(int val, int count) {
            this.val = val;
            this.count = count;
        }
        int val = 0, count = 0;
    }
}