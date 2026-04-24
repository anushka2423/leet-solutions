class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        int isPossible = 0;

        while(i < nums.length) {

            int j = i+nums[i];
            if(j >= nums.length - 1) return true;
            int prev = j+nums[j];
            int nextInd = j;

            while(j > i) {
                if(prev < j+nums[j]) {
                    nextInd = j;
                    prev = j+nums[j];
                }
                j--;
            }
            i = nextInd;

            if(nums[i] == 0) return false;
            
        }

        return true;
    }
}