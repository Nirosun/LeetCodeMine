public class Solution {
  public boolean isValid(String s) {
    if (s == null) return true;

    char[] chars = s.toCharArray();
    if (chars.length == 0 || chars.length % 2 == 1) return false;

    LinkedList<Character> stack = new LinkedList<Character>();

    for (int i = 0; i < chars.length; i ++) {
      if (isPair(stack.peek(), chars[i]))
        stack.pop();
      else
        stack.push(chars[i]);
    }

    return stack.isEmpty();
  }

  private boolean isPair(Character c1, Character c2) {
    if (c1 != null
      && ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}'))) {
      return true;
    }
    return false;
  }
}
