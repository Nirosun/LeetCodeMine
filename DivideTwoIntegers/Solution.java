public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long a = (dividend >= 0) ? dividend : -(long)dividend;  // avoid dividend = Integer.MIN_VALUE
        long b = (divisor >= 0) ? divisor : -(long)divisor;     // the same

        long quotient = 0;
        while (a >= b) {
            long c = b;
            for (int i = 0; a >= c; i ++, c <<= 1) {    // c increment by twice
                a -= c;
                quotient += 1 << i;
            }
        }
        return ((dividend ^ divisor) >> 31) == 0 ?  (int)quotient : (int)(-quotient);
    }
}
