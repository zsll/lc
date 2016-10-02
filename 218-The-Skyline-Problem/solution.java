public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        List<Point> points = getSortedPoint(buildings);
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer> (10, Collections.reverseOrder());
        for(Point p : points) {
            if(p.isStart) {
                if(q.isEmpty() || p.y > q.peek()) {
                    int[] cur = {p.x, p.y};
                    res.add(cur);
                } 
                q.offer(p.y);
            } else {
                q.remove(p.y);
                if(q.isEmpty() ) {
                    int[] cur = {p.x, 0};
                    res.add(cur);
                } else if(q.peek() < p.y) {
                    int[] cur = {p.x, q.peek()};
                    res.add(cur);
                }
            }
        }
        return res;
    }
    
    List<Point> getSortedPoint(int [][] buildings) {
        List<Point> res = new ArrayList<Point>();
        for(int i = 0; i < buildings.length; i++ ) {
            res.add(new Point(buildings[i][0], buildings[i][2], true));
            res.add(new Point(buildings[i][1], buildings[i][2], false));
        }
        Collections.sort(res, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if(a.x != b.x) {
                    return a.x - b.x;
                } else {
                    if(a.isStart != b.isStart) {
                        return a.isStart ? -1 : 1;
                    } else {
                        if(a.isStart) {
                            return b.y - a.y;
                        } else {
                            return a.y - b.y;
                        }
                    }
                }
            }
        });
        return res;
    }
    
    class Point {
        int x, y;
        boolean isStart;
        public Point(int x, int y, boolean isStart) {
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }
    }
}