public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int res = -1;
        if(matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int h = matrix.length, w = matrix[0].length;
            res = Integer.MIN_VALUE;
            for(int i = 0; i < h; i++) {
                int [] colSum = new int[w];
                for(int j = i; j < h; j++) {
                    //Find sum a - sum b <= k where b is smaller than a
                    //sum b >= sum a - k
                    TreeSet<Integer> s = new TreeSet<Integer>();
                    int sum = 0;
                    for(int p = 0; p < w; p++) {
                        colSum[p] += matrix[j][p];
                        sum += colSum[p];
                        if(sum <= k) {
                            res = Math.max(sum, res);
                        }
                        Integer pre = s.higher(sum - k - 1);
                        //Integer i = set.ceiling(num - k);//return the least number greater or equal to num - k
                        if(pre != null) {
                            //if(sum - pre <= k) {  //Not needed
                                res = Math.max(sum - pre, res);
                            //}
                        }
                        s.add(sum);
                    }
                }
            }
            if(res == Integer.MIN_VALUE) {
                res = -1;
            }
        }
        return res;
    }
}