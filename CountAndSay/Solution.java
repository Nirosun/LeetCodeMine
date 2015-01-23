public class Solution {
  public String countAndSay(int n) {
    String s = "1";

    while (--n) {
      s = getNext(s);
    }

    return s;
  }

  private String getNext(String s) {
    String next = "";
    int cnt = 1;
    char c = s.charAt(0);

    for (int i = 1; i < s.length(); i ++) {
      if (s.charAt(i) != c) {
        next = next + cnt + c;
        cnt = 1;
        c = s.charAt(i);
      }
      else {
        cnt ++;
      }
    }

    next = next + cnt + c;
    return next;
  }
}
