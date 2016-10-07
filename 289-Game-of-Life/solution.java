public class Solution {
    
    public void gameOfLife(int[][] board) {
        final int alive_to_dead = 1;//0 <- 1
        final int alive_to_alive = 3;   //1 <- 1
        final int dead_to_alive = 0;//
        final int dead_to_dead = 2;
        int [][] dir = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
            {1, 1},
            {1, -1},
            {-1, 1},
            {-1, -1}
        };
        int h = board.length, w = board[0].length;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                int live = 0;
                for(int k = 0; k < 8; k++) {
                    int x = i + dir[k][0], y = j + dir[k][1];
                    if(x >= 0 && x < h && y >= 0 && y < w) {
                        if(board[x][y]%2 > 0) {
                            live++;
                        }
                    }
                }
                int newState = 0;   //dead
                if(board[i][j] == 1) {
                    if(live >= 2 && live <=3) {
                        newState = 1;
                    }
                } else {
                    if(live == 3) {
                        newState = 1;
                    }
                }
                board[i][j] =  ((newState << 1) | board[i][j]);
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j]>>1;
            }
        }
    }
}