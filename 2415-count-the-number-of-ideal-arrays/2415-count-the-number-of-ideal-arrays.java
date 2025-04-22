import java.math.BigInteger;

class Solution {
    public static final int MODULO = (int) 1e9 + 7;

    public int idealArrays(int n, int maxValue) {
        // Precompute smallest divisors for factorization
        int[] minDivisor = new int[maxValue + 1];
        for (int p = 2; p <= maxValue; p++) {
            if (minDivisor[p] != 0) continue;
            for (int i = p; i <= maxValue; i += p) {
                if (minDivisor[i] == 0) minDivisor[i] = p;
            }
        }

        // Precompute binomial coefficients C(n+k-1, k)
        int maxPow = (int) (Math.log(maxValue) / Math.log(2));
        int[] binCoeff = new int[maxPow + 1];
        BigInteger comb = BigInteger.ONE;
        for (int k = 1; k <= maxPow; k++) {
            comb = comb.multiply(BigInteger.valueOf(n + k - 1))
                     .divide(BigInteger.valueOf(k));
            binCoeff[k] = comb.mod(BigInteger.valueOf(MODULO)).intValue();
        }

        // Count valid sequences for each starting value
        int total = 0;
        for (int num = 1; num <= maxValue; num++) {
            int x = num;
            long sequences = 1;
            // Factorize and calculate for each prime
            while (x > 1) {
                int p = minDivisor[x];
                int exponent = 0;
                do {
                    exponent++;
                    x /= p;
                } while (x % p == 0);
                sequences = sequences * binCoeff[exponent] % MODULO;
            }
            total = (total + (int) sequences) % MODULO;
        }
        return total;
    }
}