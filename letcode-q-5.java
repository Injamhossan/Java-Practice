class Solution {
    static final long MOD = 1_000_000_007L;

    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Extract powers of 2 from n
        List<Long> powers = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if (((n >> i) & 1) == 1) {
                powers.add(1L << i);
            }
        }

        // Step 2: Prefix products mod MOD
        int len = powers.size();
        long[] prefixProd = new long[len];
        prefixProd[0] = powers.get(0) % MOD;
        for (int i = 1; i < len; i++) {
            prefixProd[i] = (prefixProd[i - 1] * powers.get(i)) % MOD;
        }

        // Step 3: Answer queries
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1];
            if (left == 0) {
                result[i] = (int) prefixProd[right];
            } else {
                long inv = modPow(prefixProd[left - 1], MOD - 2, MOD); // modular inverse
                result[i] = (int) ((prefixProd[right] * inv) % MOD);
            }
        }
        return result;
    }

    // Modular exponentiation
    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
