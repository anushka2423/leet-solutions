class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, nums.length, 0, dp);
    }

    private int solve(int[] nums, int prev, int ind, int[][] dp) {
        if(ind == nums.length) return 0;

        if(dp[ind][prev] != -1) return dp[ind][prev];

        int take = 0;
        if(prev == nums.length || nums[prev] < nums[ind]) {
            take = 1+solve(nums, ind, ind+1, dp);
        }

        int notTake = solve(nums, prev, ind+1, dp);

        return dp[ind][prev] = Math.max(take, notTake);
    }
}