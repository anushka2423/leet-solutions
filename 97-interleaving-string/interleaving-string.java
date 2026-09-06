class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        return helper(s1, s2, s3, 0, 0, dp);
    }

    public boolean helper(String s1, String s2, String s3, int i, int j, int[][] dp) {
        int k = i+j;
        if(k == s3.length()) return true;

        if(dp[i][j] != 0) return dp[i][j] == 1;
        boolean isValid = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            isValid = helper(s1, s2, s3, i+1, j, dp);
        }
        
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            isValid = isValid || helper(s1, s2, s3, i, j+1, dp);
        }

        dp[i][j] = isValid ? 1 : 2;

        return dp[i][j] == 1;
    }
}