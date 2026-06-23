class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        List<List<Integer>> list = new ArrayList<>();

        for(int ele1 : nums1) {
            for(int ele2 : nums2) {
                int sum = ele1 + ele2;
                if(k > 0) {
                    maxHeap.add(new int[] {sum, ele1, ele2});
                    k--;
                }else if(k == 0 && maxHeap.peek()[0] > sum) {
                    maxHeap.poll();
                    maxHeap.add(new int[]{sum, ele1, ele2});
                }else {
                    break;
                }
            }
        }

        while(maxHeap.size() != 0){
            int[] temp = maxHeap.poll();
            list.add(new ArrayList<>(List.of(temp[1], temp[2])));
        }

        return list;
    }
}