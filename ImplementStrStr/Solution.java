public class Solution {
  public int strStr(String haystack, String needle) {
    if (needle.isEmpty()) return 0;

    char[] hay = haystack.toCharArray();
    char[] nee = needle.toCharArray();

    for (int i = 0; ; i ++) {
      for (int j = 0; ; j ++) {
        if (j == nee.length) return i;
        if (i + j == hay.length) return -1;
        if (nee[j] != hay[i + j]) break;
      }
    }
  }
}
