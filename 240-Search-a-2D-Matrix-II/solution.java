public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        if(matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int h = matrix.length, w = matrix[0].length, i = 0, j = w - 1;
            while(i < h && j >= 0) {
                if(matrix[i][j] == target) {
                    res = true;
                    break;
                } else if(matrix[i][j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return res;
    }
}