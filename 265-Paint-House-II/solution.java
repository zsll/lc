public class Solution {
    public int minCostII(int[][] costs) {
        int res = 0;
        if(costs != null && costs.length > 0) {
            int h = costs.length, w = costs[0].length;
            int minI = 0, min2I = 0, minVal = Integer.MAX_VALUE, min2Val = Integer.MAX_VALUE;
            for(int i = 0; i < w; i++) {
                if(costs[0][i] < minVal) {
                    
                    min2Val = minVal;//NoteNote
                    min2I = minI;
                    minVal = costs[0][i];
                    minI = i;
                } else if(costs[0][i] < min2Val) {
                    min2Val = costs[0][i];
                    min2I = i;
                }
            }
            
            for(int i = 1; i < h; i++) {
                int preMinI = minI, preMin2I = min2I;
                minVal = Integer.MAX_VALUE;
                min2Val = Integer.MAX_VALUE;
                for(int j = 0; j < w; j++) {
                    if(preMinI != j) {
                        costs[i][j] += costs[i - 1][preMinI];
                    } else {
                        costs[i][j] += costs[i - 1][preMin2I];
                    }
                    
                    if(costs[i][j] < minVal) {
                        
                        min2Val = minVal;
                        min2I = minI;
                        minVal = costs[i][j];
                        minI = j;
                    } else if(costs[i][j] < min2Val) {
                        min2Val = costs[i][j];
                        min2I = j;
                    }
                }
            }
            res = costs[h - 1][minI];
        }
        return res;
    }
}