/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int res = 0;
        if(points != null && points.length > 0) {
            res = 1;
            int len = points.length;
            for(int i = 0; i < len - 1; i++) {
                double k = Double.MIN_VALUE;
                int maxLinesThroughI = 0,//not including self, all the lines through i with same k (slope)
                count = 1;  //self
                HashMap<Double, Integer> map = new HashMap<Double, Integer>();
                for(int j = i + 1; j < len; j++) {
                    if(points[j].x == points[i].x && points[j].y == points[i].y) {
                        count++;
                    } else {
                        k = Double.MAX_VALUE;
                        if(points[j].x - points[i].x != 0) {
                            k = 1.0 *(points[j].y - points[i].y)/(points[j].x - points[i].x) + 0.0;
                        }
                        if(!map.containsKey(k)) {
                            map.put(k, 0);
                        }
                        map.put(k, map.get(k) + 1);
                        
                        maxLinesThroughI = Math.max(map.get(k), maxLinesThroughI);
                    }
                }
                res = Math.max(count + maxLinesThroughI, res);
            }
        }
        return res;
    }
}