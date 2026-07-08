class Solution {
    public int passwordStrength(String password) {
        int strength = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < password.length(); i++) {
            char curr = password.charAt(i);

            if(set.contains(curr)) continue;

            set.add(curr);
            if(curr >= 'a' && curr <= 'z') strength += 1;
            if(curr >= 'A' && curr <= 'Z') strength += 2;
            if(curr >= '0' && curr <= '9') strength += 3;
            if(curr == '!' || curr == '@' || curr == '#' || curr == '$') strength += 5;
        }

        return strength;
    }
}