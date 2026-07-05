class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        int illuminatePos = (int)Math.ceil((double)brightness/3.0);

        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        for(int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if(!list.isEmpty() && list.get(list.size()-1).get(1) >= start) {
                int oldEnd = list.get(list.size()-1).get(1);
                list.get(list.size()-1).set(1, Math.max(oldEnd, end));
            }else {
                list.add(new ArrayList<>(List.of(start, end)));
            }
        }

        long activeTime = 0;
        for(List<Integer> li : list) {
            int start = li.get(0);
            int end = li.get(1);

            activeTime += (end-start+1);
        }

        return illuminatePos * activeTime;
    }
}