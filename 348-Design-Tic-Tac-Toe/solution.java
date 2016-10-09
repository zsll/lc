public class TicTacToe {
    int [] row1, row2, col1, col2;
    int d1, d2, t1, t2; //Diagnal
    int size;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        size = n;
        row1 = new int[n];
        row2 = new int[n];
        col1 = new int[n];
        col2 = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int res = 0;
        if(player == 1) {
            row1[row]++;
            col1[col]++;
            if(row == col) {
                d1++;
            }
            if(row + col == size - 1) {
                t1++;
            }
            if(row1[row] == size || col1[col] == size || d1 == size || t1 == size) {
                res = 1;
            }
        } else {
            row2[row]++;
            col2[col]++;
            if(row == col) {
                d2++;
            }
            if(row + col == size - 1) {
                t2++;
            }
            if(row2[row] == size || col2[col] == size || d2 == size || t2 == size) {
                res = 2;
            }
        }
        return res;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */