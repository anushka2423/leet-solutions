class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    private void solve(int[] candidates, int target, int ind, List<List<Integer>> ans, List<Integer> list) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if(ind >= candidates.length || target < 0) return;

        list.add(candidates[ind]);
        solve(candidates, target-candidates[ind], ind+1, ans, list);
        list.remove(list.size()-1);
        while(ind < candidates.length-1 && (candidates[ind] == candidates[ind+1])){
            ind++;
        }
        solve(candidates, target, ind+1, ans, list);
    }
}