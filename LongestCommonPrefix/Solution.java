public class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    if (strs.length == 1) return strs[0];

    /*
    for (int i = 0; i < strs.length; i ++) {
      if (strs[i] == null || "".equals(strs[i])) return "";
    }
    */

    /*for (int i = 0; ; i ++) {
      if (i == strs[0].length()) return strs[0].substring(0, i);
      String prefix = strs[0].substring(0, i + 1);
      for (int j = 0; j < strs.length; j ++) {
        if (i == strs[j].length() || !strs[j].startsWith(prefix))
          return strs[0].substring(0, i);
      }
    }*/
    int index = 0;

    out:
    while (true) {
      if (index >= strs[0].length()) break;
      char c = strs[0].charAt(index);

      for (int i = 1; i < strs.length; i ++) {
        if (index >= strs[i].length() || strs[i].charAt(index) != c)
          break out;
      }
      index ++;
    }

    return strs[0].substring(0, index);

  }
}
