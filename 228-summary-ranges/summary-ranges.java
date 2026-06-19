class Solution {
    public List<String> summaryRanges(int[] nums) {
        int ind = 0;
        List<String> list = new ArrayList<>();

        while(ind < nums.length) {
            int prev = ind;
            while(ind < nums.length-1 && nums[ind]+1 == nums[ind+1]) {
                ind++;
            }
            StringBuilder strs = new StringBuilder("");
            strs.append(nums[prev]);

            if(ind > prev) {
                strs.append("->").append(nums[ind]);
            }
            list.add(strs.toString());
            ind++;
        }

        return list;
    }
}