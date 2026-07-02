class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int count = 0;
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) {
            long sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];

                if(check(sum, x)) count++;
            }
        }

        return count;
    }
    private boolean check(long sum, int x) {
        sum = Math.abs(sum);

        int last = (int)(sum % 10);

        while (sum >= 10) {
            sum /= 10;
        }

        int first = (int)sum;

        return first == x && last == x;
    }
}