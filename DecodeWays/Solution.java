public class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        if (n == 0 || chars[0] == '0')  return 0;

        int prev = 0, cur = 1; // prev <=> f[i-1], cur <=> f[i]

        for (int i = 1; i <= n; i ++) {
            if (chars[i - 1] == '0')
                cur = 0;
            if (i < 2 || !(chars[i - 2] == '1' || (chars[i - 2] == '2' && chars[i - 1] <= '6')))
                prev = 0;
            int tmp = cur;
            cur = cur + prev;
            prev = tmp;
        }

        return cur;
    }
}
