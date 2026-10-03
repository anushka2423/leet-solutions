class Solution {
    public int characterReplacement(String s, int k) {
        // set -> unique char store ()
        // loop on each element -> so that we can know which element have max lenght


        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        int maxLen = 0;
        for(Character ele : set) {
            int count = 0;
            int start = 0;
            int len = 0;
            for(int end = 0; end < s.length(); end++) {
                if(s.charAt(end) != ele) count++;

                while(count > k && start < s.length()) {
                    if(s.charAt(start) != ele) count--;
                    start++;
                }

                len = Math.max(end-start+1, len);
            }
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}