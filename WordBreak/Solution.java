public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        char[] chars = s.toCharArray();
        boolean[] f = new boolean[chars.length + 1];
        Arrays.fill(f, false);

        f[0] = true;

        for (int i = 1; i <= chars.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                }
            }
        }

        return f[chars.length];
    }
}
