public class Solution {
  public int atoi(String str) {
    if (str == null || "".equals(str)) return 0;

    char[] chars = str.toCharArray();
    int num = 0;
    int sign = 1;
    boolean signSeen = false;
    int s = 0;

    while (s < chars.length && !(chars[s] >= '0' && chars[s] <= '9')) {
      if (signSeen) {
        return 0;
      }
      else {
        if (chars[s] == '+') {
          sign = 1;
          signSeen = true;
        }
        else if (chars[s] == '-') {
          sign = -1;
          signSeen = true;
        }
        else if (chars[s] != ' ') {
          return 0;
        }
      }
      s ++;
    }

    int e = s;
    while (e < chars.length && (chars[e] >= '0' && chars[e] <= '9')) {
      e ++;
    }

    boolean isOverflow = false;

    for (int i = s; i < e; i ++) {
      if (num > Integer.MAX_VALUE / 10
      || (num == Integer.MAX_VALUE / 10
      && chars[i] - '0' > Integer.MAX_VALUE % 10)) {
        isOverflow = true;
        break;
      }
      num = num * 10 + chars[i] - '0';
    }
    if (isOverflow) {
      if (sign == 1) return Integer.MAX_VALUE;
      else return Integer.MIN_VALUE;
    }

    num *= sign;

    return num;
  }
}
