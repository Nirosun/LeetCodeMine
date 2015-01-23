public class Solution {
  public boolean isPalindrome(String s) {
    if (s.isEmpty()) return true;
    int n = s.length();

    String sLower = s.toLowerCase();
    int i = 0, j = n - 1;

    while (i < j) {
      char ci = sLower.charAt(i);
      char cj = sLower.charAt(j);
      if (!isAlphaNum(ci)) {
        i ++;
        continue;
      }
      if (!isAlphaNum(cj)) {
        j --;
        continue;
      }
      if (ci == cj) {
        i ++;
        j --;
        continue;
      }
      return false;
    }
    return true;
  }

  private boolean isAlphaNum(char c) {
    if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) return true;
    return false;
  }
}
