class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int ele : arr) map.put(ele, map.getOrDefault(ele, 0)+1);

        int maxCount = 0;
        int sum = 0;
        int[] freq = new int[map.size()];
        int ind = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int curr = entry.getValue();
            freq[ind++] = curr;
        }

        Arrays.sort(freq);
        int len = arr.length;
        for(int i = freq.length-1; i >= 0; i--) {
            maxCount++;
            len -= freq[i];
            if(len <= arr.length/2) break;
        }

        return maxCount;
    }
}