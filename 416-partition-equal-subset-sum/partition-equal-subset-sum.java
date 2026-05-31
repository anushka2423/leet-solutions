class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums) sum += ele;

        if(sum%2 == 1) return false;
        int[][] dp = new int[nums.length][sum+1];
        for(int i = 0; i < nums.length; i++)
            Arrays.fill(dp[i], 0);
        
        return solve(nums, sum, sum, 0, dp);
    }

    private boolean solve(int[] nums, int sum, int target, int ind, int[][] dp) {
        if(target == sum/2) return true;
        if(target < sum/2) return false;
        if(ind == nums.length) return false;

        if(dp[ind][target] != 0) return dp[ind][target] == 1 ? true : false;

        dp[ind][target] = solve(nums, sum, target - nums[ind], ind+1, dp) || solve(nums, sum, target, ind+1, dp) ? 1 : -1;

        return dp[ind][target] == 1 ? true : false;
    }
}