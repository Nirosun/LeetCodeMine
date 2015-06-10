public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int m = n;
        int cnt = 0;
        
        while (m != 0) {
            cnt += m & 1;
            m >>>= 1;
        }
        
        return cnt;
    }
}