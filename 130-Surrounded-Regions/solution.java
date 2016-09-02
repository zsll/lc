public class Solution {
    public void solve(char[][] board) {
        if(board != null && board.length > 0 && board[0].length > 0) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][0] == 'O') {
                    bfs(board, i, 0);
                }
                if(board[i][board[0].length - 1] == 'O') {
                    bfs(board, i, board[0].length - 1);
                }
            }
            for(int i = 1; i < board[0].length - 1; i++) {
                if(board[0][i] == 'O') {
                    bfs(board, 0, i);
                }
                if(board[board.length - 1][i] == 'O') {
                    bfs(board, board.length - 1, i);
                }
            }
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(board[i][j] == 'Y') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
    
    void bfs(char [][] board, int i, int j) {
        int [][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };
        Queue<Integer> rowQ = new LinkedList<Integer>();
        Queue<Integer> colQ = new LinkedList<Integer>();
        rowQ.offer(i);
        colQ.offer(j);
        board[i][j] = 'Y';
        while(!rowQ.isEmpty()) {
            i = rowQ.poll();
            j = colQ.poll();
            for(int k = 0; k < 4; k++) {
                int x = i + directions[k][0], y = j + directions[k][1];
                if(x >= 0 && x < board.length && y >=0 && y < board[0].length && board[x][y] == 'O') {
                    rowQ.offer(x);
                    colQ.offer(y);
                    board[x][y] = 'Y';
                }
            }
        }
    }
}