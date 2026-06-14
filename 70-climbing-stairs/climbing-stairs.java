class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n >= 1) dp[1] = 1;
        if(n >= 2) dp[2] = 2;
        
        return helper(n, dp);
    }

    private int helper(int n, int[] dp) {
        if(dp[n] != 0) return dp[n];

        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    }
}