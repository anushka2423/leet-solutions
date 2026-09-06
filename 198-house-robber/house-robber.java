class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return Math.max(helper(nums, 0, dp), helper(nums, 1, dp));
    }
    public int helper(int[] nums, int ind, int[] dp) {

        if(ind >= nums.length) return 0;
        if(dp[ind] != -1) return dp[ind];

        dp[ind] = nums[ind] + Math.max(helper(nums, ind+2, dp), helper(nums, ind+3, dp));
        return dp[ind];
    }
}