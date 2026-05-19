class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        if(k > nums.length) return 0;
        long maxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        long sum = 0;
        for(int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            sum += nums[i];
        }

        if(map.size() == k) maxSum = Math.max(maxSum, sum);
        int start = 0;
        for(int end = k; end < nums.length; end++) {
            map.put(nums[start], map.get(nums[start])-1);
            if(map.get(nums[start]) == 0) map.remove(nums[start]);
            sum -= nums[start];
            start++;
            map.put(nums[end], map.getOrDefault(nums[end], 0)+1);
            sum += nums[end];

            if(map.size() == k)
                maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}