public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<Edge> el = produceSortedEdges(buildings);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        List<int[]> res = new ArrayList<int[]>();
        
        for(Edge e : el) {
            if(e.isStart) {
                if(pq.size() == 0 || e.height > pq.peek()) {
                    int [] cur = {0, 0};
                    cur[0] = e.pos;
                    cur[1] = e.height;
                    res.add(cur);
                }
                pq.offer(e.height);
            } else {
                pq.remove(e.height);    //can be optimized using hashheap
                if(pq.size() == 0 || e.height > pq.peek()) {
                    int [] cur = {0, 0};
                    cur[0] = e.pos;
                    if(pq.size() > 0) { //NoteNote
                    /**
                     * Runtime Error Message:
Line 21: java.lang.NullPointerException
Last executed input:
[[0,1,3]]*/
                        cur[1] = pq.peek();
                    }
                    res.add(cur);
                }
            }
        }
        return res;
    }
    
    class Edge {
        boolean isStart = false;
        int height = 0, pos = 0;
        public Edge(boolean isStart, int height, int pos) {
            this.isStart = isStart;
            this.height = height;
            this.pos = pos;
        }
    }
    
    List<Edge> produceSortedEdges(int[][] buildings) {
        List<Edge> res = new ArrayList<Edge>();
        if(buildings != null && buildings.length > 0) {
            for(int i = 0; i < buildings.length; i++) {
                res.add(new Edge(true, buildings[i][2], buildings[i][0]));
                res.add(new Edge(false, buildings[i][2], buildings[i][1]));
            }
            Collections.sort(res, new Comparator<Edge>() {
                @Override
                public int compare(Edge a, Edge b) {
                    if(a.pos != b.pos) {
                        return Integer.compare(a.pos, b.pos);
                    } else {
                        if(a.isStart != b.isStart) {
                            return a.isStart ? -1 : 1;  //if one start, one end, start first
                        } else {
                            if(a.isStart) { //both start, higher first
                                return a.height >= b.height ? -1 : 1;
                            } else {
                                return a.height >= b.height ? 1 : -1;//both end, lower first
                            }
                        }
                    }
                }
            });
        }
        return res;
    }
}