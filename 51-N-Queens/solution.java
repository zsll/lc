public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(n > 0) {
            int [] col = new int[n];
            boolean [] colOccu = new boolean[n];
            boolean [] diag1Occu = new boolean[2*n - 1];
            boolean [] diag2Occu = new boolean[2*n - 1];
            dfs(col, colOccu, diag1Occu, diag2Occu, 0, res);
        }
        return res;
    }
    
    void dfs(int [] col, boolean [] colOccu, boolean [] diag1Occu, boolean [] diag2Occu, int startRow, List<List<String>> res) {
        if(startRow == col.length) {
            res.add(print(col));
        } else {
            for(int i = 0; i < col.length; i++) {
                if(isValid(startRow, i, colOccu, diag1Occu, diag2Occu)) {
                    colOccu[i] = true;
                    //diag1 index, start + col; diag2 index, col + n - 1 - row
                    diag1Occu[i + startRow] = true;
                    diag2Occu[i + col.length - 1 - startRow] = true;
                    col[startRow] = i;
                    dfs(col, colOccu, diag1Occu, diag2Occu, startRow + 1, res);
                    
                    colOccu[i] = false;
                    //diag1 index, start + col; diag2 index, col + n - 1 - row
                    diag1Occu[i + startRow] = false;
                    diag2Occu[i + col.length - 1 - startRow] = false;
                }
            }
        }
    }
    //i is col
    boolean isValid(int row, int i, boolean [] colOccu, boolean [] diag1Occu, boolean [] diag2Occu) {
        return !colOccu[i] && !diag1Occu[i + row] && !diag2Occu[i + colOccu.length - 1 - row];
    }
    
    List<String> print(int [] col) {
        List<String> res = new ArrayList<String>();
        int len = col.length;
        for(int i = 0; i < len; i++) {
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < len; j++) {
                sb.append('.');
            }
            sb.setCharAt(col[i], 'Q');
            res.add(sb.toString());
        }
        return res;
    }
}