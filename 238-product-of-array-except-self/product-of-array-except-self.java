class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int prevProd = 1;

        for(int i = 0; i < nums.length; i++) {
            ans[i] = prevProd;
            prevProd *= nums[i];
        }

        prevProd = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            ans[i] *= prevProd;
            prevProd *= nums[i];
        }

        return ans;
    }
}