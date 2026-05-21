class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(s, 0, dp);
    }

    private int solve(String s, int ind, int[] dp) {
        if(ind == s.length()) return 1;

        if(dp[ind] != -1) return dp[ind];

        int ans = 0;

        if(s.charAt(ind) != '0') {
            ans += solve(s, ind+1, dp);
            dp[ind] = ans;
        }

        if(ind < s.length()-1) {
            String part = s.substring(ind, ind+2);
            if(Integer.parseInt(part) <= 26 && part.charAt(0) != '0') {
                ans += solve(s, ind+2, dp);
                dp[ind] = ans;
            }
        }

        return ans;
    }
}