public class Solution {
  public int romanToInt(String s) {

    char[] ss = s.toCharArray();
    int num = 0;

    for (int i = 0; i < ss.length; i ++) {
      if (i > 0 && map(ss[i]) > map(ss[i - 1])) {
        num += map(ss[i]) - 2 * map(ss[i - 1]);
      }
      else {
        num += map(ss[i]);
      }
    }

    return num;
  }

  public int map(char c) {
    switch (c) {
      case 'I': return 1;
      case 'V': return 5;
      case 'X': return 10;
      case 'L': return 50;
      case 'C': return 100;
      case 'D': return 500;
      case 'M': return 1000;
    }
    return 0;
  }
}
