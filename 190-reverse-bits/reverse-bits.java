class Solution {
    public int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(binary);

        sb = sb.reverse();
        int size = 32 - sb.length();

        while(size != 0) {
            sb.append("0");
            size--;
        }

        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
}