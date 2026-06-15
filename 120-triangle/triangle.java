class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];

        return solve(triangle, 0, 0, dp);
    }

    private int solve(List<List<Integer>> triangle, int row, int col, Integer[][] dp) {
        if(row == triangle.size() || col == triangle.get(row).size()) return 0;

        if (dp[row][col] != null) {
            return dp[row][col];
        }

        int down = solve(triangle, row + 1, col, dp);
        int diagonal = solve(triangle, row + 1, col + 1, dp);

        return dp[row][col] =
                triangle.get(row).get(col) + Math.min(down, diagonal);
    }
}