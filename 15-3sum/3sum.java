class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int start = i+1, end = nums.length-1;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            while(start < end) {
                int curr = nums[start]+nums[end];

                if(curr == -nums[i]){
                    // if(ans.size() != 0){
                    //     List<Integer> forCompare = ans.get(ans.size()-1);
                    //     if(forCompare.get(0) == nums[i] && forCompare.get(1) == nums[start] && forCompare.get(2) == nums[end]) {
                    //         start++;
                    //         end--;

                    //         continue;
                    //     }
                    // }
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);

                    ans.add(list);
                    start++;
                    while(start < end && nums[start] == nums[start-1]) start++;
                    end--;
                    while(start < end && nums[end] == nums[end+1]) end--;
                }else if(curr > -nums[i]) {
                    end--;
                }else {
                    start++;
                }
            }
        }

        return ans;
    }
}