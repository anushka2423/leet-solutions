class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int[] row : dp) Arrays.fill(row, -1);

        return solve(0, s1, 0, s2, 0, s3, dp);
    }

    private boolean solve(int i, String s1, int j, String s2, int k, String s3, int[][] dp) {
        if(i == s1.length() && j == s2.length() && k == s3.length()) return true;

        if(dp[i][j] != -1) return dp[i][j] == 0 ? false : true;

        boolean case1 = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            case1 = solve(i+1, s1, j, s2, k+1, s3, dp);
        }

        boolean case2 = false;
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            case2 = solve(i, s1, j+1, s2, k+1, s3, dp);
        }

        dp[i][j] = case1||case2 ? 1 : 0;

        return dp[i][j] == 0 ? false : true;
    }
}