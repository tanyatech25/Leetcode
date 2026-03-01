class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;

        for (char c : n.toCharArray()) {
            int digit = c - '0';
            if (digit > maxDigit) {
                maxDigit = digit;
            }
            if (maxDigit == 9) return 9; // early stop
        }

        return maxDigit;
    }
}