class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][]dp = new int[coins.length][amount+1];
        int ans = solve(coins, amount, dp, 0);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int solve(int[] coins, int amount, int[][] dp, int ind) {
        if(amount == 0) return 0;
        if(amount < 0 || ind >= coins.length) return Integer.MAX_VALUE;

        if(dp[ind][amount] != 0) return dp[ind][amount];

        int take = solve(coins, amount - coins[ind], dp, ind);
        int notTake = solve(coins, amount, dp, ind + 1);

        int ans = Integer.MAX_VALUE;

        if (take != Integer.MAX_VALUE)
            ans = Math.min(ans, 1 + take);

        ans = Math.min(ans, notTake);

        return dp[ind][amount] = ans;
    }
}