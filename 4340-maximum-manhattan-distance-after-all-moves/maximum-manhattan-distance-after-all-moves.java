class Solution {
    public int maxDistance(String moves) {
        int maxDis = 0;
        int x = 0, y = 0;
        for(int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            if(ch == '_') maxDis++;
            else if(ch == 'L') {
                x -= 1;
            }else if(ch == 'R') {
                x += 1;
            }else if(ch == 'U') {
                y -= 1;
            }else {
                y += 1;
            }
        }

        maxDis += Math.abs(x)+Math.abs(y);
        return maxDis;
    }
}