class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxSum = 0, sum = 0;
        int start = 0;
        for(int end = 0; end < nums.length; end++) {
            while(set.contains(nums[end])) {
                set.remove(nums[start]);
                sum -= nums[start];
                start++;
            }
            set.add(nums[end]);
            sum += nums[end];

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}