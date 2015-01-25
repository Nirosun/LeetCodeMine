public class Solution {
  public int lengthOfLastWord(String s) {

    /*String[] words = s.split(" ");

    if (words.length == 0) return 0;

    return words[words.length - 1].length();*/

    char[] chars = s.toCharArray();

    int end = chars.length - 1;

    while (end >= 0 && chars[end] == ' ') end --;

    int len = 0;

    for (int i = 0; i <= end; i ++) {
      if (chars[i] == ' ')  len = 0;
      else  len ++;
    }

    return len;

  }
}
