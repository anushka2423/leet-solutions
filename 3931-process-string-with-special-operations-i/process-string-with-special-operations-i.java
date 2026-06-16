class Solution {
    public String processStr(String s) {
        StringBuilder ans = new StringBuilder("");

        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case '*':
                    if(ans.length() != 0) ans.deleteCharAt(ans.length()-1);
                    break;
                
                case '#':
                    if(ans.length() != 0) ans.append(ans);
                    break;

                case '%':
                    if(ans.length() != 0) ans.reverse();
                    break;

                default:
                    ans.append(s.charAt(i));
                    break;
            }
        }

        return ans.toString();
    }
}