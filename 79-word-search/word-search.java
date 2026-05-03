class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(helper(board, word, 0, i, j)) return true; 
            } 
        }

        return false;
    }

    private boolean helper(char[][] board, String word, int n, int row, int col) {
        if(col >= board[0].length || col < 0 || row < 0 || row >= board.length) return false;
        if(word.charAt(n) != board[row][col]) return false;

        if(n == word.length()-1) return true;

        char temp = board[row][col];

        board[row][col] = '#';

        boolean compute = helper(board, word, n+1, row, col+1) || helper(board, word, n+1, row+1, col) || helper(board, word, n+1, row, col-1) || helper(board, word, n+1, row-1, col);

        board[row][col] = temp;

        return compute;

    }
}