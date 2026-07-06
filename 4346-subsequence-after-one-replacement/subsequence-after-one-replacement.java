class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int i = 0, j = 0, n = s.length();

        for(int k = 0; k < t.length(); k++) {
            char curr = t.charAt(k);

            j = Math.max(j + (j < n && curr == s.charAt(j) ? 1 : 0), i+1);
            i += i < n && curr == s.charAt(i) ? 1 : 0;
        }

        return j >= n;
    }
}