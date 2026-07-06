class Solution {
    public int maxDigitRange(int[] nums) {
        int maxSum = 0;
        int maxRange = 0;

        for(int ele : nums) {
            int small = 10, large = 0;

            int temp = ele;
            while(temp > 0) {
                int rem = temp%10;
                small = Math.min(small, rem);
                large = Math.max(large, rem);

                temp /= 10;
            }

            int range = large-small;
            if(range > maxRange) {
                maxSum = ele;
                maxRange = range;
            }else if(range == maxRange) maxSum += ele;
        }

        return maxSum;
    }
}