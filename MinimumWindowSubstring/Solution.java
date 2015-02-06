public class Solution {
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();

        if (s.length < t.length)    return "";

        final int ASCII_MAX = 128;
        int[] appearCount = new int[ASCII_MAX];
        int[] expectCount = new int[ASCII_MAX];

        int appeared = 0;
        int minWindow = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int minStart = 0;

        Arrays.fill(appearCount, 0);
        Arrays.fill(expectCount, 0);

        for (int i = 0; i < t.length; i++) {
            expectCount[(int)t[i]] ++;
        }

        for (; end < s.length; end ++) {
            if (expectCount[(int)s[end]] > 0) {
                appearCount[(int)s[end]] ++;
                if (appearCount[(int)s[end]] <= expectCount[(int)s[end]]) {
                    appeared ++;
                }
            }

            if (appeared == t.length) {
                while (expectCount[(int)s[start]] == 0 ||
                    appearCount[(int)s[start]] > expectCount[(int)s[start]]) {
                    appearCount[(int)s[start]] --;
                    start ++;
                }
                if (end - start + 1 < minWindow) {
                    minWindow = end - start + 1;
                    minStart = start;
                }
            }
        }

        if (minWindow == Integer.MAX_VALUE)
            return "";

        return S.substring(minStart, minStart + minWindow);
    }
}
