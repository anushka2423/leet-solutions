class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        return helper(s, wordDict, new StringBuilder(), map);
    }

    private boolean helper(String s, List<String> wordDict, StringBuilder sb, Map<String, Boolean> map) {
        if(sb.toString().equals(s)) return true;
        if(sb.length() > s.length()) return false;

        if(map.containsKey(sb.toString())) return map.get(sb.toString());

        boolean ans = false;
        for(int i = 0; i < wordDict.size(); i++) {
            sb.append(wordDict.get(i));
            int wordLength = wordDict.get(i).length();
            if(sb.length() > s.length()) {
                sb.setLength(sb.length() - wordLength);
                continue;
            }

            if(sb.toString().equals(s.substring(0, sb.length()))){
                ans = ans || helper(s, wordDict, sb, map);
            }
            sb.setLength(sb.length() - wordLength);
            if(ans) break;
        }
        map.put(sb.toString(), ans);

        return map.get(sb.toString());
    }
}