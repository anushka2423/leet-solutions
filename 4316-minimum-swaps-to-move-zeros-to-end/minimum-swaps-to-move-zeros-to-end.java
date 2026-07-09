class Solution {
    public int minimumSwaps(int[] nums) {
        int count = 0;
        int i = 0, j = nums.length-1;

        while(i < j) {
            while(j >= 0 && nums[j] == 0) {
                j--;
            }
            if(i < j && nums[i] == 0) {
                count++;
                i++;
                j--;
            }else {
                i++;
            }
        }

        return count;
    }
}