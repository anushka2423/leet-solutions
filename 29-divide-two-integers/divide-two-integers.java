class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if(divisor == 1) return dividend;
        if(dividend == -1) return -dividend;

        int sign = 1;
        if(dividend<0 && divisor<0) sign = 1;
        else if(dividend<0 || divisor<0) sign = -1;

        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);

        int quotient = 0;

        while( n >= d ) {
            long tempDivisor = d;
            long multiple = 1;

            while (n >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            n -= tempDivisor;
            quotient += multiple;
        }

        return sign*quotient;
    }
}