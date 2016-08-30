public class Solution {
    
    public void gameOfLife(int[][] board) {
        final int alive_to_dead = 1;
        final int alive_to_alive = 3;
        final int dead_to_alive = 0;
        final int dead_to_dead = 2;
        int [][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
            {1, 1},
            {1, -1},
            {-1, 1},
            {-1, -1}
        };
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int live = 0;
                for(int k = 0; k < 8; k++) {
                    int x = i + directions[k][0], y = j + directions[k][1];
                    if(x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                        if(board[x][y]%2 == 1) {
                            live++;
                        } 
                        
                        
                    }
                }
                if(board[i][j] == 1) {
                    if(live < 2 || live > 3) {
                        board[i][j] =  alive_to_dead;
                    } else {
                        board[i][j] =  alive_to_alive;
                    } 
                } else {
                    if(live == 3) {
                        board[i][j] = dead_to_alive;
                    } else {
                        board[i][j] = dead_to_dead;
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 3 || board[i][j] == 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}