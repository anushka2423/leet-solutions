class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // List<List<Integer>> list = new ArrayList<>();
        
        // Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        // for(int[] interval : intervals) {
        //     int start = interval[0];
        //     int end = interval[1];

        //     if(!list.isEmpty() && list.get(list.size()-1).get(1) >= end) {
        //         continue;
        //     }else {
        //         list.add(new ArrayList<>(List.of(start, end)));
        //     }
        // }

        // return list.size();
        
        int lastEnd = -1, lastStart = -1, count = 0;
        
        Arrays.sort(intervals, (a, b) ->
            a[0] == b[0]
                ? Integer.compare(b[1], a[1]) // descending on second element
                : Integer.compare(a[0], b[0]) // ascending on first element
        );
        
        for(int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if(lastEnd != -1 && lastEnd >= end) {
                continue;
            }else {
                count++;

                lastStart = start;
                lastEnd = end;
            }
        }

        return count;
    }
}