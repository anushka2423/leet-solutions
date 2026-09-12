class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length-1;

        while(start <= end) {
            int curr = numbers[start]+numbers[end];

            if(curr == target) return new int[]{start+1, end+1};

            if(curr > target) {
                end--;
            }else {
                start++;
            }
        }

        return new int[]{};
    }
}