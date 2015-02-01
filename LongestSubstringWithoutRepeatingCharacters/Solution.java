public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int NUM_CHARS = 128;
        int[] last = new int[NUM_CHARS];    // last appear of every char
        int start = 0;  // start of current substring
        int maxLen = 0;

        char[] chars = s.toCharArray();
        Arrays.fill(last, -1);

        for (int i = 0; i < chars.length; i ++) {
            int index = (int)(chars[i] - '\0');
            if (last[index] >= start) { // repeat
                int len = i - start;
                maxLen = (maxLen > len) ? maxLen : len;
                start = last[index] + 1;
            }
            last[index] = i;
        }

        return (maxLen > chars.length - start) ? maxLen : chars.length - start;
    }
}
