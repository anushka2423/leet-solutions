class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(grid, dp, 0, 0);
    }

    private int solve(int[][] grid, int[][] dp, int m, int n) {
        if(m >= grid.length || n >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if(m == grid.length-1 && n == grid[0].length-1) return grid[m][n];
        
        if(dp[m][n] != -1) return dp[m][n];

        dp[m][n] = grid[m][n] + Math.min(solve(grid, dp, m+1, n), solve(grid, dp, m, n+1));

        return dp[m][n];
    }
}