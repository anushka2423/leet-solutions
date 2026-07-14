class Solution {
    public int countKthRoots(int l, int r, int k) {
        
        int lower = (int)Math.ceil(Math.pow(l, 1.0/k)-0.00000000009);
        int higher = (int)Math.floor(Math.pow(r, 1.0/k)+0.000000001);

        return higher-lower+1;
    }
}