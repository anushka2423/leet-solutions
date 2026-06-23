class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;

        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') continue;
                
                count++;
                countBattle(i, j, board);
            }
        }

        return count;
    }

    private void countBattle(int row, int col, char[][] board) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '.') return;

        board[row][col] = '.';

        countBattle(row, col-1, board);
        countBattle(row-1, col, board);
        countBattle(row, col+1, board);
        countBattle(row+1, col, board);
    }
}