public class Solution {
    public String convertToTitle(int n) {
        if (n <= 26) {
            return "" + (char) ('A' + n - 1);
        }
        if (n % 26 == 0) {  // Special case for 'Z'
            return convertToTitle(n / 26 - 1) + "Z";
        }
        return convertToTitle(n / 26) + convertToTitle(n % 26);
    }
}