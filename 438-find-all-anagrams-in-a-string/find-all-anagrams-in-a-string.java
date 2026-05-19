class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        List<Integer> ans = new ArrayList<>();

        for(char c : p.toCharArray()) {
            pFreq[c-'a']++;
        }

        int start = 0;
        for(int i = 0; i < p.length(); i++) {
            sFreq[s.charAt(i)-'a']++;
        }

        if(Arrays.equals(pFreq, sFreq)) ans.add(start);

        for(int end = p.length(); end < s.length(); end++) {
            sFreq[s.charAt(start)-'a']--;
            start++;
            sFreq[s.charAt(end)-'a']++;
            if(Arrays.equals(pFreq, sFreq)) ans.add(start);
        }

        return ans;
    }
}