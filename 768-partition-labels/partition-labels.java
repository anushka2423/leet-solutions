class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] chars = new int[26];

        for(int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)-'a']++;
        }

        Set<Character> set = new HashSet<>();
        int ind = 0;
        while(ind < s.length()) {
            set.add(s.charAt(ind));
            chars[s.charAt(ind)-'a']--;
            if(chars[s.charAt(ind)-'a'] == 0) set.remove(s.charAt(ind));
            int len = 1;
            ind++;
            while(ind < s.length() && !set.isEmpty()) {
                char currChar = s.charAt(ind);
                set.add(currChar);
                chars[currChar-'a']--;
                if(chars[currChar-'a'] == 0) set.remove(currChar);
                len++;
                ind++;
            }

            ans.add(len);
        }

        return ans;
    }
}
