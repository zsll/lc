public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int h = matrix.length, w = matrix[0].length, totalLevel = (Math.min(h, w) + 1)/2, level = totalLevel;
            int i = 0, j = 0, dir = 0;  //mod 0 is right, 1 is down, 2 is left, 3 is up
            if(w == 1) {
                /**
                 * Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 8: java.lang.ArrayIndexOutOfBoundsException: 1
Last executed input:
[[3],[2]]*/
                dir++;
            }
            while(res.size() < h*w) {
                res.add(matrix[i][j]);
                if(res.size() == h*w) {
                    /**
                     * Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 18: java.lang.ArrayIndexOutOfBoundsException: -1
Last executed input:
[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]*/
                    ;//break;
                }
                switch(dir%4) {
                    case 0:
                        j++;
                        if(j == w - 1 - (totalLevel - level)) {
                            dir++;
                        }
                        break;
                    case 1:
                        i++;
                        if(i == h - 1 - (totalLevel - level)) {
                            dir++;
                        }
                        break;
                    case 2:
                        j--;
                        if(j == (totalLevel - level)) {
                            dir++;
                        }
                        break;
                    default://case 0:
                        i--;
                        if(i == 1 + (totalLevel - level)) {
                            dir++;
                            level--;    //NoteNote
                        }
                        break;
                }
                
            }
        }
        return res;
    }
}