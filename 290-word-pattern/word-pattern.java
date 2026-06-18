class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> revMap = new HashMap<>();

        String[] word = s.split(" ");

        if(pattern.length() != word.length) return false;

        for(int i = 0; i < pattern.length(); i++) {
            if(!map.containsKey(pattern.charAt(i))) map.put(pattern.charAt(i), word[i]);

            if(!revMap.containsKey(word[i])) revMap.put(word[i], pattern.charAt(i));

            if(!map.get(pattern.charAt(i)).equals(word[i]) || revMap.get(word[i]) != pattern.charAt(i)) return false;
        }

        return true;
    }
}