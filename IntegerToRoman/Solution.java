public class Solution {
  public String intToRoman(int num) {

    /*int[] vals = {1, 5, 10, 50, 100, 500, 1000};
    char[] symbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    String str = "";

    for (int i = vals.length - 1; i >= 0; i --) {
      int cnt = num / vals[i];
      num %= vals[i];

      if (cnt == 0)
      if (cnt == 4) {
        str = str + symbols[i] + symbols[i + 1];
      }
      else if (cnt == 9) {
        str = str + symbols[i] + symbols[i + 2];
      }
      else

    }*/

    int[] radix = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    String str = "";

    for (int i = 0; num > 0; i ++) {
      int cnt = num / radix[i];
      num %= radix[i];

      for (; cnt > 0; cnt --) {
        str = str + symbol[i];
      }
    }

    return str;
  }
}
