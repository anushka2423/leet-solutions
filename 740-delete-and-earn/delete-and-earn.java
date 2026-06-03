class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int ele : nums) map.put(ele, map.getOrDefault(ele, 0)+1);

        int[] eles = new int[map.size()];
        int ind = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            eles[ind++] = entry.getKey();
        }

        Arrays.sort(eles);
        int[] dp = new int[eles.length];
        
        return solve(eles, map, dp, 0);
    }

    private int solve(int[] eles, Map<Integer, Integer> map, int[] dp, int ind) {
        if(ind == eles.length) return 0;

        if(dp[ind] != 0) return dp[ind];

        int case1 = eles[ind]*map.get(eles[ind]);
        if(ind < eles.length-1 && eles[ind+1] == eles[ind]+1) { 
            case1 += solve(eles, map, dp, ind+2);
        }
        else case1 += solve(eles, map, dp, ind+1);

        dp[ind] = Math.max(case1, solve(eles, map, dp, ind+1));

        return dp[ind];
    }
}