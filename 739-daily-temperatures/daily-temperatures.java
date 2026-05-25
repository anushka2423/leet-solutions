class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int[] temp = stack.pop();
                ans[temp[1]] = i-temp[1];
            }
            stack.add(new int[]{temperatures[i], i});
        }

        return ans;
    }
}