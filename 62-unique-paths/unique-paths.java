class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];
        return solve(0, 0, m, n, dp);
    }

    private int solve(int row, int col, int m, int n, Integer[][] dp) {
        if(row == m-1 && col == n-1) return 1;

        if(dp[row][col] != null) return dp[row][col];

        int ans = 0;
        if(row < m-1) {
            ans += solve(row+1, col, m, n, dp);
        }

        if(col < n-1) {
            ans += solve(row, col+1, m, n, dp);
        }

        dp[row][col] = ans;

        return dp[row][col];
    }
}