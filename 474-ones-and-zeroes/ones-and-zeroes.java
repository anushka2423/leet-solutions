class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[] zero = new int[strs.length];
        int[] one = new int[strs.length];

        for(int j = 0; j < strs.length; j++) {
            String str = strs[j];
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i)-'0' == 0) zero[j]++;
                else one[j]++;
            }
        }

        int[][][] dp = new int[zero.length][m+1][n+1];
        int ans = solve(zero, one, m, n, 0, dp);
        return ans < 0 ? 0 : ans;
    }

    private int solve(int[] zero, int[] one, int m, int n, int ind, int[][][]dp) {
        if(m < 0 || n < 0) return -1;
        if(ind >= zero.length) return 0;

        if(dp[ind][m][n] != 0) return dp[ind][m][n];

        dp[ind][m][n] = Math.max(1+solve(zero, one, m - zero[ind], n - one[ind], ind+1, dp), solve(zero, one, m, n, ind+1, dp));

        return dp[ind][m][n];
    }
}