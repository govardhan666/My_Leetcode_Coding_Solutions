class Solution {
    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenPower = power(5, evenCount);
        long oddPower = power(4, oddCount);

        long result = (evenPower * oddPower) % MOD;
        return (int) result; // since return type is int
    }

    // Fast power function with modulo
    private long power(long base, long exp) {
        long result = 1;
        base = base % MOD;

        while (exp > 0) {
            if ((exp % 2) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp = exp / 2;
        }

        return result;
    }
}