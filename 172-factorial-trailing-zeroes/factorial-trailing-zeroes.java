class Solution {
    public int trailingZeroes(int n) {
        int zeros = 0;
        int div = 5;
        while(div <= n) {
            zeros += n/div;
            div *= 5;
        }

        return zeros;
    }
}