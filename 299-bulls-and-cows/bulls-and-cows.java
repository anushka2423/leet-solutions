class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        StringBuilder s = new StringBuilder(secret);
        StringBuilder g = new StringBuilder(guess);

        int[] key = new int[10];

        for(int i = 0; i < secret.length(); i++) {
            if(s.charAt(i) == g.charAt(i)) {
                s.setCharAt(i, '#');
                g.setCharAt(i, '#');
                bulls++;
            }else {
                key[s.charAt(i)-'0']++;
            }
        }

        for(int i = 0; i < g.length(); i++) {
            if(g.charAt(i) != '#' && key[g.charAt(i)-'0'] > 0) {
                cows++;
                key[g.charAt(i)-'0']--;
            }
        }

        return bulls+"A"+cows+"B";
    }
}