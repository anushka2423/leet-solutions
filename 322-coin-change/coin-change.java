class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] dp = new Integer[coins.length][amount+1];
        int len = solve(coins, amount, 0, dp);

        return len == Integer.MAX_VALUE ? -1 : len;
    }

    private int solve(int[] coins, int amount, int ind, Integer[][] dp) {
        if(amount == 0) return 0;
        if(ind >= coins.length || amount < 0) return Integer.MAX_VALUE;

        if(dp[ind][amount] != null) return dp[ind][amount];

        int minCoin = Integer.MAX_VALUE;
        for(int i = ind; i < coins.length; i++) {
            int res = solve(coins, amount-coins[i], i, dp);

            if(res != Integer.MAX_VALUE) 
                minCoin  = Math.min(minCoin, res+1);
        }

        dp[ind][amount] = minCoin;
        return dp[ind][amount];
    }
}