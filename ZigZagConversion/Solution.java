public class Solution {
    public String convert(String s, int nRows) {
        //StringBuilder[] sb = new StringBuilder[nRows];
        String[] strs = new String[nRows];
        char[] chars = s.toCharArray();
        int index = 0;

        for (int i = 0; i < strs.length; i ++) {
            strs[i] = "";
        }

        while (index < chars.length) {
            for (int i = 0; i < nRows && index < chars.length; i ++, index ++) {
                //sb[i].append(chars[index]);
                strs[i] += chars[index];
            }
            for (int i = nRows - 2; i > 0 && index < chars.length; i--, index ++) {
                //sb[i].append(chars[index]);
                strs[i] += chars[index];
            }
        }

        String result = "";
        for (int i = 0; i < strs.length; i ++) {
            //result += sb[i].toString();
            result += strs[i];
        }
        return result;
    }
}
