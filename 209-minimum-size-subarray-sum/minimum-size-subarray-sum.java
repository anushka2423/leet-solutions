class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;

        for(int right = 0; right < nums.length; right++) {
            int element = nums[right];
            sum += element;

            while(left < nums.length && sum >= target) {
                minLen = Math.min(minLen, right-left+1);
                sum -= nums[left];

                left++;
            }
        }

        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}