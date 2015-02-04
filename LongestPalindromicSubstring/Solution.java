public class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0)	return new String("");

        String longest = s.substring(0, 1);

        for (int i = 0; i < chars.length - 1; i ++) {
            String s1 = expanded(chars, i, i);
            if (s1.length() > longest.length())	longest = s1;

            String s2 = expanded(chars, i, i + 1);
            if (s2.length() > longest.length())	longest = s2;
        }
        return longest;
    }

    String expanded(char[] s, int c1, int c2) {
        int l = c1, r = c2;
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l --;
            r ++;
        }
        return new String(Arrays.copyOfRange(s, ++l, r));
    }
}
