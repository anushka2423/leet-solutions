class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for(int i = 0; i < n; i++) {
            count += solve(s, i, i, n);
            count += solve(s, i, i+1, n);
        }

        return count;
    }

    private int solve(String s, int l, int r, int n) {
        if(l < 0 || r == n) return 0;
        if(s.charAt(l) != s.charAt(r)) return 0;

        return 1 + solve(s, --l, ++r, n);
    }
}