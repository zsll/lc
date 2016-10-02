public class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                
                boolean [][] v = new boolean[board.length][board[0].length];
                if(dfs(word, 0, board, i, j, v)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean dfs(String word, int pos, char [][] board, int i, int j, boolean [][] v) {
        if(pos == word.length()) {
            return true;
        } else if(i >= 0 && j >= 0 && i < board.length && j < board[0].length && !v[i][j] && board[i][j] == word.charAt(pos)){
            v[i][j] = true;
            int [][] dir = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
            };
            for(int k = 0; k < 4; k++) {
                int x = i + dir[k][0], y = j + dir[k][1];
                if(dfs(word, pos + 1, board, x, y, v)) {
                    return true;
                }
            }
            v[i][j] = false;
        }
        return false;
    }
}