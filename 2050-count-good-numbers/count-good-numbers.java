class Solution {
    int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long even = n/2;
        long prime = n/2;

        if(n%2 != 0){
            even = even+1;
        }
        long ep = modPow(5, even, MOD);
        long op = modPow(4, prime, MOD);

        long ans = (ep*op)%MOD;

        return (int)ans;   
    }
    private static long modPow(long base, long exp, long mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}