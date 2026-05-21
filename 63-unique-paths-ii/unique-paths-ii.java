class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Integer[][] dp = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return solve(0, 0, obstacleGrid, dp);
    }

    private int solve(int row, int col, int[][] obstacleGrid, Integer[][] dp) {
        if(obstacleGrid[row][col] == 1) return 0;
        if(row == obstacleGrid.length-1 && col == obstacleGrid[0].length-1) return 1;

        if(dp[row][col] != null) return dp[row][col];

        int ans = 0;
        if(row < obstacleGrid.length-1) {
            ans += solve(row+1, col, obstacleGrid, dp);
        }

        if(col < obstacleGrid[0].length-1) {
            ans += solve(row, col+1, obstacleGrid, dp);
        }

        dp[row][col] = ans;

        return dp[row][col];
    }
}