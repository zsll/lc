public class Solution {
    public void solveSudoku(char[][] board) {
        boolean res = true;
        List<Integer> spaces = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    spaces.add(i*9 + j);
                }
            }
        }
        dfs(board, spaces, 0);
    }
    
    boolean dfs(char[][] board, List<Integer> spaces, int pos) {
        if(pos == spaces.size()) {
            return true;
        } else {
            int row = spaces.get(pos)/9, col = spaces.get(pos)%9;
            for(int i = 1; i <= 9; i++) {
                if(isValid(board, row, col, i)) {
                    board[row][col] = (char)(i + '0');//NoteNote
                    if(dfs(board, spaces, pos + 1)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    
    boolean isValid(char[][] board, int row, int col, int val) {
        for(int i = 0; i < 9; i++) {
            if(board[row][i] - '0' == val || board[i][col] - '0' == val) {
                return false;
            }
            int r = row/3*3 + i/3, c = col/3*3 + i%3;
            if(board[r][c] - '0' == val) {
                return false;
            }
        }
        return true;
    }
}