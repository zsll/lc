public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = 0;
         if (m > 0) n = matrix[0].length;
         if (m * n == 0) return 0;
         
         int M = Math.max(m, n);
         int N = Math.min(m, n);
         
         int ans = Integer.MIN_VALUE;
         for (int x = 0; x < N; x++) {	//Start row/col
             int sums[] = new int[M];//sum of col/row, updated every time
             for (int y = x; y < N; y++) {	//End row/col
                 TreeSet<Integer> set = new TreeSet<Integer>();
                 int num = 0;
                 for (int z = 0; z < M; z++) {
                     sums[z] += m > n ? matrix[z][y] : matrix[y][z];
                     num += sums[z];
                     if (num <= k) 
                    	 ans = Math.max(ans, num);
                     Integer i = set.ceiling(num - k);//return the least number greater or equal to num - k
                     //find the max number that is smaller than or equal to num minus k
                     if (i != null) //Note ceiling might return null
                    	 ans = Math.max(ans, num - i);
                     set.add(num);
                 }
             }
         }
         return ans;
    }
}