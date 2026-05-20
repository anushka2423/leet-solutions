class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        int maxLen = 0;
        Iterator<Character> it = set.iterator();
        while(it.hasNext()) {
            char item = it.next();
            int count = 0, left = 0;;
            for(int right = 0; right < s.length(); right++) {
                if(s.charAt(right) != item) count++;
                if(count <= k) maxLen = Math.max(maxLen, right-left+1);

                while(count > k) {
                    if(s.charAt(left) != item) count--;
                    left++;
                }
            } 
            it.remove();
        }

        return maxLen;
    }
}