class Solution {
    public String smallestSubsequence(String s) {
        int[] chars = new int[26];

        for(int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)-'a']++;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if(!stack.contains(currChar)) {
                while(!stack.isEmpty() && stack.peek()-'a' > currChar-'a' && chars[stack.peek()-'a'] > 0) {
                    stack.pop();
                }
                stack.push(currChar);
            }
            chars[currChar-'a']--;
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        ans.reverse();
        return ans.toString();
    }
}