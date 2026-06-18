class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;

        for(int ele : nums) set.add(ele);

        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()) {
            int ele = iterator.next();
            int len = 1;
            
            if (!set.contains(ele - 1)) {
                while(set.contains(ele+1)){ 
                    len++;
                    ele++;
                }
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}