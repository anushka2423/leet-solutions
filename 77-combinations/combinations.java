class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(n, k, ans, new ArrayList<>(), 1);
        return ans;
    }

    private void solve(int n, int k, List<List<Integer>> ans, List<Integer> list, int ind) {
        if(list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = ind; i < n+1; i++) {
            list.add(i);
            solve(n, k, ans, list, i+1);
            list.remove(list.size()-1);
        }
    }
}