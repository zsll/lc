public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean r = false;
if(matrix != null && matrix.length > 0) {
if(matrix[0].length > 0) {
int h = matrix.length, w = matrix[0].length; int i = 0, j = w - 1;
while(i < h && j >= 0) {
int c = matrix[i][j]; if(c == target) {
r = true;
break; }
if(c > target) { j--;
} else { i++;
} }
} }
return r;
    }
}