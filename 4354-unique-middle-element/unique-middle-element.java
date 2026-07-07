class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int midEle = nums[nums.length/2];
        int fre = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == midEle) fre++;

            if(fre > 1) return false;
        }

        return true;
    }
}