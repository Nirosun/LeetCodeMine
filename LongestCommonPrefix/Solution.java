public class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    if (strs.length == 1) return strs[0];

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
