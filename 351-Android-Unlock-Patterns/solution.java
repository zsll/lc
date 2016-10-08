public class Solution {
    public int numberOfPatterns(int m, int n) {
        int res = 0;
        if(m > 0 && n >= m) {
            int [] count = {0};
            HashSet<Integer> v = new HashSet<Integer>();
            dfs(1, 1, m, n, v, count);  //NoteNote, initiate len with 1, not 0
            res += count[0]*4;
            count[0] = 0;
            dfs(2, 1, m, n, v, count);
            res += count[0]*4;
            count[0] = 0;
            dfs(5, 1, m, n, v, count);
            res += count[0];
        } 
        return res;
    }
    
    void dfs(int start, int len, int m, int n, HashSet<Integer> v, int [] count) {
        if(len >= m && len <= n) {
            count[0]++;
        }
        if(len < n) {
            v.add(start);
            for(int i = 1; i <= 9; i++) {
                if(canGo(start, i, v)) {
                    dfs(i, len + 1, m, n, v, count);
                }
            }
            v.remove(start);
        }
    }
    
    boolean canGo(int start, int to, HashSet<Integer> v) {
        int [][] block = new int[10][10];
        block[1][3] = 2;
        block[3][1] = 2;
        block[1][7] = 4;
        block[7][1] = 4;
        block[7][9] = 8;
        block[9][7] = 8;
        block[9][3] = 6;
        block[3][9] = 6;
        block[1][9] = 5;
        block[9][1] = 5;
        block[3][7] = 5;
        block[7][3] = 5;
        block[4][6] = 5;
        block[6][4] = 5;
        block[2][8] = 5;
        block[8][2] = 5;
        return !v.contains(to) && start != to && (block[start][to] == 0 || v.contains(block[start][to]));
    }
}