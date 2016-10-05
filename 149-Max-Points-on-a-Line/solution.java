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
            if(points.length > 1) {
                for(int i = 0; i < points.length; i++) {
                    HashMap<Double, Integer> h = new HashMap<Double, Integer>();
                    int dup = 1;//self
                    for(int j = 0; j < points.length; j++) {
                        if(i != j) {
                            if(points[i].y == points[j].y && points[i].x == points[j].x) {
                                dup++;
                                res = Math.max(dup, res);
                            } else {
                                Double k = Double.MAX_VALUE;
                                if(points[i].x != points[j].x) {
                                    k = 1.0*(points[i].y - points[j].y)/(points[i].x - points[j].x);//Line 27: error: incompatible types: int cannot be converted to Double
                                }
                                if(!h.containsKey(k)) {
                                    h.put(k, 0);
                                }
                                int pre = h.get(k);
                                h.put(k, pre + 1);
                                res = Math.max(dup + h.get(k), res);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}