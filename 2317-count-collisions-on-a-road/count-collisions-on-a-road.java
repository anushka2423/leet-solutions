class Solution {
    public int countCollisions(String directions) {
        int col = 0;
        Stack<Character> stack = new Stack<>();

        for(char dir : directions.toCharArray()) {
            if(dir == 'R' || stack.isEmpty()) stack.push(dir);
            else {
                if(dir == 'L') {
                    if(!stack.isEmpty() && stack.peek() == 'R') {
                        col += 2;
                        stack.pop();
                        dir = 'S';

                        while(!stack.isEmpty() && stack.peek() == 'R') {
                            col += 1;
                            stack.pop();
                        }
                    } else if(!stack.isEmpty() && stack.peek() == 'S') {
                        col += 1;
                        dir = 'S';
                    }
                } else if(dir == 'S') {
                    while(!stack.isEmpty() && stack.peek() == 'R') {
                        col += 1;
                        stack.pop();
                    }
                } 

                stack.push(dir);
            }
        }

        return col;
    }
}