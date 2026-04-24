class Solution {
    public int jump(int[] nums) {
        int i = 0;
        int jumps = 0;

        if(nums.length < 2) return 0;

        while(i < nums.length) {

            int j = i+nums[i];
            if(j >= nums.length - 1) return jumps+1;
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
            jumps++;
            
        }

        return jumps+1;
    }
}