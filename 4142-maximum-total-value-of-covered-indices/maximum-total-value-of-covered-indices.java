class Solution {
    public long maxTotal(int[] nums, String s) {
        int lastNum = 0;
        long maxValue = 0;
        for(int i = 0; i < nums.length; i++) {
            if(s.charAt(i) == '0') {
                lastNum = nums[i];
            }else {
                if(lastNum > nums[i]) {
                    maxValue += lastNum;
                    lastNum = nums[i];
                }else 
                    maxValue += nums[i];
            }
        }

        return maxValue;
    }
}