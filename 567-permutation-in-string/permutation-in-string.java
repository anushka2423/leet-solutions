class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int[] char1 = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            char1[s1.charAt(i)-'a']++;
        }

        int start = 0, end = 0;
        int[] char2 = new int[26];

        for(; end < s1.length(); end++){
            char2[s2.charAt(end)-'a']++;
        }

        end--;
        while(end < s2.length()) {
            if(Arrays.equals(char1, char2)) return true;

            char2[s2.charAt(start)-'a']--;
            start++;
            end++;
            if(end < s2.length()) char2[s2.charAt(end)-'a']++;
        }

        return Arrays.equals(char1, char2);
    }
}