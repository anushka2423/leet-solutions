class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());

                String operand = tokens[i];
                int ans = 0;
                switch(operand) {
                    case "+":
                        ans = a+b;
                        break;
                    case "-":
                        ans = a-b;
                        break;
                    case "*":
                        ans = a*b;
                        break;
                    case "/":
                        ans = a/b;
                        break;
                }
                stack.push(String.valueOf(ans));
            }else {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}