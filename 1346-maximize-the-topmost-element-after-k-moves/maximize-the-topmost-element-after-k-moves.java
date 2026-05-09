class Solution {
    public int maximumTop(int[] nums, int k) {
        int ind = 0;
        int currmax = 0;

        if(k == 0) return nums[0];
        if(nums.length == 1) {
            return (k % 2 == 1) ? -1 : nums[0];
        }

        while(ind < nums.length && ind < k-1) {
            currmax = Math.max(currmax, nums[ind]);
            ind++;
        }

        if(ind > nums.length-2) return currmax;

        return Math.max(currmax, nums[ind+1]);
    }
}