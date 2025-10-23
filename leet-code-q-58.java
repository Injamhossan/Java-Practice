class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        int k = n - 2;
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) digits[i] = s.charAt(i) - '0';

        int[] row = new int[k + 1];
        row[0] = 1;
        for (int r = 1; r <= k; r++) {
            int[] next = new int[r + 1];
            next[0] = 1;
            next[r] = 1;
            for (int j = 1; j < r; j++) {
                next[j] = (row[j - 1] + row[j]) % 10;
            }
            row = next;
        }

        int first = 0, second = 0;
        for (int i = 0; i <= k; i++) {
            first = (first + row[i] * digits[i]) % 10;
            second = (second + row[i] * digits[i + 1]) % 10;
        }

        return first == second;
    }
}
