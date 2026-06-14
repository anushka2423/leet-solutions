class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(nums, dp, 0);
    }

    private int solve(int[] nums, int[] dp, int ind) {
        if(ind >= nums.length) return 0;

        if (dp[ind] != -1) return dp[ind];

        dp[ind] = Math.max(nums[ind]+solve(nums, dp, ind+2), solve(nums, dp, ind+1));
        return dp[ind];
    }
}