public class Solution {
    public boolean isIsomorphic(String s, String t) {
        final int CHAR_NUM = 256;
        char[] replace = new char[CHAR_NUM];
        boolean[] used = new boolean[CHAR_NUM];
        
        Arrays.fill(replace, '\0');
        
        for (int i = 0; i < s.length(); i ++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (replace[(int) sChar] == '\0' && !used[(int) tChar]) {   // first replace (tChar not used)
                replace[(int) sChar] = tChar;
                used[(int) tChar] = true;
            }
            else if ( (replace[(int) sChar] == '\0' && used[(int) tChar]) || // first replace (tChar used)
                replace[(int) sChar] != tChar) {    // not first time, tChar not match
                return false;
            }
        }
        return true;
    }
}