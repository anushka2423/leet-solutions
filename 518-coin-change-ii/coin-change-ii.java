class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(amount, coins, 0, dp); 
    }

    private int solve(int amount, int[] coins, int ind, int[][] dp) {
        if(amount == 0) return 1;
        if(amount < 0) return 0;
        if(ind == coins.length) return 0;

        if(dp[ind][amount] != -1) return dp[ind][amount];
        
        dp[ind][amount] = solve(amount-coins[ind], coins, ind, dp) + solve(amount, coins, ind+1, dp);

        return dp[ind][amount];
    }
}