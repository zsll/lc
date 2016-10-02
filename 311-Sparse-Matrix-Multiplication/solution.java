public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0 || A[0].length == 0 || B[0].length == 0) {
            return null;
        }
        int h = A.length, w = B[0].length, p = B.length;
        int [][] res = new int[h][w];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < p; j++) {
                if(A[i][j] != 0) {  //NoteNote
                    for(int k = 0; k < w; k++) {
                        res[i][k] += A[i][j]*B[j][k];
                    }
                }
            }
        }
        return res;
    }
}