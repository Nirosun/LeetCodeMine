public class Solution {

    // partition[i] = s[0, i] + partition[i + 1, end]
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();

        if (s == null || s.equals(""))  return result;

        for (int i = 0; i < s.length(); i ++) { // start with every s[0, i]
            String x = s.substring(0, i + 1);
            if (isPal(x)) { // s[0, i] is palindrome, examine the rest of s
                List<List<String>> subResult = partition(s.substring(i + 1, s.length()));
                // partition result of s[i + 1, end]

                if (subResult.isEmpty()) {  // reach the end of s, add new list
                    result.add(Arrays.asList(x));
                }
                else {  // merge and add partition result
                    for (List<String> l : subResult) {
                        List<String> _l = new ArrayList<String>();
                        _l.add(x);
                        _l.addAll(l);
                        result.add(_l);
                    }
                }

            }
        }

        return result;
    }

    private boolean isPal(String x) {
        char[] chars = x.toCharArray();
        for (int i = 0; i < chars.length / 2; i ++) {
            if (chars[i] != chars[chars.length - 1 - i])
                return false;
        }
        return true;
    }
}
