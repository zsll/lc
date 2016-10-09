public class Solution {
    public boolean isReflected(int[][] points) {
        
        HashSet<String> s = new HashSet<String>();  //Assume there is no duplicate
        int maxX = Integer.MIN_VALUE, minX = Integer.MAX_VALUE;
        for(int [] p : points) {
            maxX = Math.max(maxX, p[0]);
            minX = Math.min(minX, p[0]);
            s.add(p[0] + "_" + p[1]);
        }
        double axisX = (maxX - minX)/2.0 + minX;
        
        for(int [] p : points) {
            int x = p[0], y = p[1];
            if((double)x == axisX) {
                /**
                 *Submission Result: Wrong Answer More Details 

Input:
[[1,1],[1,1],[1,1]]
Output:
false
Expected:
true*/
                continue;
            }
            int reflectX = (int)(axisX*2 - x);
            int [] reflect = {reflectX, y};
            if(!s.contains(reflect[0] + "_" + reflect[1])) {
                return false;
            }
        }
        return true;
    }
}