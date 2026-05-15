class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        if(s.length() < 11) return ans;

        int start = 0;
        for(int end = 9; end < s.length(); end++) {
            String DNASequence = s.substring(start, end+1);
            start++;
            map.put(DNASequence, map.getOrDefault(DNASequence, 0)+1);
        }

        map.forEach((key, value) -> {
            if(value > 1) ans.add(key);
        });

        return ans;
    }
}