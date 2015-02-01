public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0) {
            result.add("");
            return result;
        }
        /*if (n == 1) {
            result.add("()");
            return result;
        }*/

        for (int i = 0; i < n; i ++) {
            for (String inner : generateParenthesis(i))
                for (String outer : generateParenthesis(n - 1 - i))
                    result.add("(" + inner + ")" + outer);
        }
        return result;
    }
}
