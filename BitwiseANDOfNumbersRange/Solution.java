public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int mask = -1;  // all 1
        while ((m & mask) != (n & mask)) {
            mask <<= 1;
        }
        return m & mask;
    }
}