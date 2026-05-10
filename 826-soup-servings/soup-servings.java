class Solution {
    public double soupServings(int n) {
        if(n >= 4800) return 1;

        Double[][] dp = new Double[n + 1][n + 1];
        return helper(n, n, dp);
    }

    private double helper(int soupA, int soupB, Double[][] dp) {
        if(soupA <= 0 && soupB <= 0) return 0.5;
        if(soupA <= 0) return 1;
        if(soupB <= 0) return 0;

        if(dp[soupA][soupB] != null) return dp[soupA][soupB];

        dp[soupA][soupB] = 0.25*(helper(soupA-100, soupB, dp)
        + helper(soupA-75, soupB-25, dp)
        + helper(soupA-50, soupB-50, dp)
        + helper(soupA-25, soupB-75, dp));

        return dp[soupA][soupB];
    }
}