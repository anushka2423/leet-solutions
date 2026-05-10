class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        Double[][][] dp = new Double[n][n][k+1];

        return helper(row, column, k, dp, n);
    }

    private double helper(int row, int col, int k, Double[][][] dp, int n) {

        if(row < 0 || col < 0 || row > n-1 || col > n-1) return 0;
        if(k <= 0) return 1;

        if(dp[row][col][k] != null) return dp[row][col][k];

        dp[row][col][k] = 1.0/8*(helper(row-2, col-1, k-1, dp, n)
            + helper(row-1, col-2, k-1, dp, n)
            + helper(row+2, col-1, k-1, dp, n)
            + helper(row+1, col-2, k-1, dp, n)
            + helper(row-2, col+1, k-1, dp, n)
            + helper(row-1, col+2, k-1, dp, n)
            + helper(row+2, col+1, k-1, dp, n)
            + helper(row+1, col+2, k-1, dp, n));

        return dp[row][col][k];
    }
}