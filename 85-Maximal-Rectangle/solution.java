public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        if(matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int h = matrix.length, w = matrix[0].length;
            for(int i = 0; i < h; i++) {
                int [] colSum = new int[w];
                for(int j = i; j < h; j++) {
                    int preFull = 0;
                    for(int k = 0; k < w; k++) {
                        colSum[k] += matrix[j][k] - '0';
                        if(colSum[k] == j - i + 1) {
                            preFull++;  //previous col occupies entire section
                            res = Math.max(res, preFull* ( j - i + 1 ));
                        } else {
                            preFull = 0;
                        }
                    }
                }
            }
        }
        return res;
    }
}