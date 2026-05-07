class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int[] maxProduct = new int[n];
        int[] minProduct = new int[n];

        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];

        int ans = nums[0];

        for(int i = 1; i < n; i++) {

            int a = nums[i];
            int b = nums[i] * maxProduct[i-1];
            int c = nums[i] * minProduct[i-1];

            maxProduct[i] = Math.max(a, Math.max(b, c));
            minProduct[i] = Math.min(a, Math.min(b, c));

            ans = Math.max(ans, maxProduct[i]);
        }

        return ans;
    }
}