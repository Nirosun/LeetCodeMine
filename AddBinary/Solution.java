public class Solution {
  public String addBinary(String a, String b) {
    if (a == null || b == null) return null;

    int n = Math.max(a.length(), b.length());

    char[] aChars = a.toCharArray();
    char[] bChars = b.toCharArray();
    int aLen = aChars.length;
    int bLen = bChars.length;

    int[] sum = new int[n + 1];

    for (int i = 0; i < n; i ++) {
      sum[i] += toInt(aChars, aLen - 1 - i) + toInt(bChars, bLen - 1 - i);
      sum[i + 1] = sum[i] / 2;
      sum[i] %= 2;
    }

    String s = "";
    for (int i = n - 1; i >= 0; i --) {
      s = s + sum[i];
    }

    if (sum[n] == 1) s = "1" + s;

    return s;

  }

  private int toInt(char[] s, int i) {
    if (i < 0 || i >= s.length) return 0;
    return s[i] - '0';
  }
}
