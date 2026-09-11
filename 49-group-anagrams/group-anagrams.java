class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String sorted = sortString(strs[i]);
            if(!map.containsKey(sorted)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sorted, list);
            }else {
                map.get(sorted).add(strs[i]);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    private String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}