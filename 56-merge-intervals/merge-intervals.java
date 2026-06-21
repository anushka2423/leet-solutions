class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> list = new ArrayList<>();

        for(int[] interval : intervals) {
            if(list.size() > 0 && list.get(list.size()-1).get(1) >= interval[0]) {
                int prevEnd = list.get(list.size()-1).get(1);
                list.get(list.size() - 1).set(1, Math.max(prevEnd, interval[1]));
            }else {
                list.add(new ArrayList<>(List.of(interval[0], interval[1])));
            }
        }

        int[][] mergedArr = new int[list.size()][2];

        for(int i = 0; i < list.size(); i++) {
            mergedArr[i][0] = list.get(i).get(0);
            mergedArr[i][1] = list.get(i).get(1);
        }

        return mergedArr; 
    }
}