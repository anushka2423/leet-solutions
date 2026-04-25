class Solution {
    public void gameOfLife(int[][] board) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int ele = board[i][j];
                int count = 0;
                
                for(int ind = 0; ind < 8; ind++) {
                    int ni = i + dx[ind];
                    int nj = j + dy[ind];
                    if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length) {
                        if (board[ni][nj] == 1 || board[ni][nj] == 4) count++;
                    }
                }

                if(ele == 1 && (count < 2 || count > 3)) board[i][j] = 4;
                else if(ele == 0 && count == 3) board[i][j] = 5;
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 4) board[i][j] = 0;
                if(board[i][j] == 5) board[i][j] = 1;
            }
        }
    }
}