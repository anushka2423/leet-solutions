class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sa = s.split(" ");
        char[] pa = pattern.toCharArray();
        
        if(pa.length != sa.length) return false;

        Map<Character, String> pmap = new HashMap<>();
        Map<String, Character> smap = new HashMap<>();
        for(int i = 0; i < pa.length; i++) {
            if(pmap.containsKey(pa[i]) && !pmap.get(pa[i]).equals(sa[i])) {
                return false;
            }
            if(smap.containsKey(sa[i]) && !smap.get(sa[i]).equals(pa[i])) {
                return false;
            }
            
            pmap.put(pa[i], sa[i]);
            smap.put(sa[i], pa[i]);
        }

        return true;
    }
}