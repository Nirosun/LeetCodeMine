public class Solution {
    public String multiply(String num1, String num2) {
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();

        int[] paper = new int[s1.length + s2.length];

        Arrays.fill(paper, 0);

        for (int i = 0; i < s1.length; i ++) {
            for (int j = 0; j < s2.length; j ++) {
                // paper: low to high
                paper[paper.length - (i + j + 2)] += (s1[i] - '0') * (s2[j] - '0');
            }
        }

        for (int i = 0; i < paper.length - 1; i ++) {
            paper[i + 1] += paper[i] / 10;
            paper[i] %= 10;
        }

        String s = "";
        for (int i = paper.length - 1; i > 0; i --) {
            if (paper[i] == 0 && "".equals(s))	continue;
            s += paper[i];
        }
        s += paper[0];  // 0 * 0

        return s;
    }
}
