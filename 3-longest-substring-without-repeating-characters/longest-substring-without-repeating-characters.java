class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxAnswer = 0;
        Set<Character> set = new HashSet<>();

        for(int end = 0; end < s.length(); end++) {
            while(!set.isEmpty() && set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            maxAnswer = Math.max(maxAnswer, end-start+1);
        }

        return maxAnswer;
    }
}