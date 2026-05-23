class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num : nums) total += num;

        int[][] dp = new int[nums.length][2*total+1];

        for(int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, target, dp, 0, 0, total);
    }

    private int solve(int[] nums, int target, int[][] dp, int ind, int sum, int total) {
        if(ind == nums.length) {
            return sum == target ? 1 : 0;
        }

        if(ind > nums.length) return 0;

        if(dp[ind][total+sum] != -1) return dp[ind][total+sum];

        dp[ind][total+sum] = solve(nums, target, dp, ind+1, sum-nums[ind], total) + solve(nums, target, dp, ind+1, sum+nums[ind], total);

        return dp[ind][total+sum];
    }
}