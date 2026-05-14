class Solution {
    public boolean isGood(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        for(int i = 1; i < nums.length; i++) {
            if(!map.containsKey(i)) return false;
        }

        if(!map.containsKey(nums.length-1) || map.get(nums.length-1) != 2) return false;

        return true;
    }
}