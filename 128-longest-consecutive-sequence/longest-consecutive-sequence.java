class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = 1, maxLen = 0;

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for(int num : set) {
            len = 1;
            if(set.contains(num-1)) continue;
            while(set.contains(num+1)){
                len++;
                num++;
            }
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}