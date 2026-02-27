class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int zeros = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }

        // already equal
        if (zeros == 0) return 0;

        // cannot choose k indices
        if (k > n) return -1;

        // try minimum operations
        int t = (zeros + k - 1) / k;

        // adjust for parity + feasibility
        while (true) {
            long total = 1L * t * k;

            // parity condition
            if ((total - zeros) % 2 == 0) {
                long ones = n - zeros;

                long extra = total - zeros;

                long maxExtra =
                        2L * zeros * ((t - 1) / 2) +
                        2L * ones * (t / 2);

                if (extra <= maxExtra) return t;
            }

            t++;

            // safe stop (impossible)
            if (t > n + 5) return -1;
        }
    }
}