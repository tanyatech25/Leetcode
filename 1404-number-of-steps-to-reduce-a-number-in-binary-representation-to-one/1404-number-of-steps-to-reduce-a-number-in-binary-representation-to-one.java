class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        // right se left traverse (last bit ko skip, kyunki 1 pe rukna hai)
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0';

            if (bit + carry == 1) {
                // odd number -> +1 then /2
                steps += 2;
                carry = 1;
            } else {
                // even number -> /2
                steps += 1;
            }
        }

        // agar last me carry bacha hai
        return steps + carry;
    }
}