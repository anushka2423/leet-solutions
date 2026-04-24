class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0, dash = 0;
        for(int i = 0; i < moves.length(); i++) {
            if(moves.charAt(i) == 'L') left++;
            else if(moves.charAt(i) == 'R') right++;
            else dash++;
        }

        if(left > right) return left+dash-right;

        return right+dash-left;
    }
}