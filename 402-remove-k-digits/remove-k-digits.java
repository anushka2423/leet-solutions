class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < num.length(); i++) {
            while(!stack.isEmpty() && k > 0 && stack.peek()-'0' > num.charAt(i)-'0'){
                stack.pop();
                k--;
            }
            stack.add(num.charAt(i));
        }

        while(!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        while(sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.length() == 0 ? "0" : sb.toString(); 
    }
}