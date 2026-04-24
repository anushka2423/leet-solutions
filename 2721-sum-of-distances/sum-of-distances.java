class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        long[] ans = new long[n];

        // Step 1: store indices
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: process each group
        for (List<Integer> arr : map.values()) {
            int size = arr.size();
            long[] prefix = new long[size];

            prefix[0] = arr.get(0);
            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + arr.get(i);
            }

            for (int i = 0; i < size; i++) {
                long left = 0;
                long right = 0;

                if (i > 0) {
                    left = (long) i * arr.get(i) - prefix[i - 1];
                }

                if (i < size - 1) {
                    right = (prefix[size - 1] - prefix[i]) 
                            - (long)(size - i - 1) * arr.get(i);
                }

                ans[arr.get(i)] = left + right;
            }
        }

        return ans;
    }
}