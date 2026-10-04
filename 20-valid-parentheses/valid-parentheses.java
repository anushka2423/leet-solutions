class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ele = s.charAt(i);
            if(!stack.isEmpty() && ((ele == ')' && stack.peek() == '(') || (ele == '}' && stack.peek() == '{') || (ele == ']' && stack.peek() == '['))) {
                stack.pop();
            }else {
                stack.push(ele);
            }
        }

        return stack.isEmpty();
    }
}