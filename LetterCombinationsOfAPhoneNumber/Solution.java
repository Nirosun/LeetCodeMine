public class Solution {
    private List<String> result;
    private char[] stack;
    private char[][] map = {
        {},
        {},
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };

    private void find(char[] digits, int p) {
        if (p == stack.length) {
            result.add(new String(stack));
            return;
        }

        for (char c : map[digits[p] - '0']) {
            stack[p] = c;
            find(digits, p + 1);
        }

    }

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<String>();
        stack = new char[digits.length()];

        find(digits.toCharArray(), 0);

        return result;
    }
}
