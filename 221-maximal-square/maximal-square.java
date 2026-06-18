class Solution {
    public int maximalSquare(char[][] matrix) {
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];

        int maxLen = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                maxLen = Math.max(solve(matrix, i, j, dp), maxLen);
            }
        }

        return maxLen*maxLen;
    }

    private int solve(char[][] matrix, int row, int col, Integer[][] dp) {
        if(row == matrix.length || col == matrix[0].length) return 0;

        if(matrix[row][col] == '0') return 0;

        if(dp[row][col] != null) return dp[row][col];

        int right = solve(matrix, row, col+1, dp);
        int diag = solve(matrix, row+1, col+1, dp);
        int down = solve(matrix, row+1, col, dp);

        return dp[row][col] = 1+ Math.min(right, Math.min(diag, down));
    }
}