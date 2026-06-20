class Solution {
    public void solve(char[][] board) {
        for(int i = 0; i < board[0].length; i++) {
            if(board[0][i] == 'O') {
                solve(0, i, board);
            }
            if(board[board.length-1][i] == 'O') {
                solve(board.length-1, i, board);
            }
        }

        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O') {
                solve(i, 0, board);
            }
            if(board[i][board[0].length-1] == 'O') {
                solve(i, board[0].length-1, board);
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void solve(int i, int j, char[][] board) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') return;

        board[i][j] = '#';

        solve(i+1, j, board);
        solve(i, j+1, board);
        solve(i, j-1, board);
        solve(i-1, j, board);
    }
}