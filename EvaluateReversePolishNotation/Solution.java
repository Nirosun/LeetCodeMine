public class Solution {
  public int evalRPN(String[] tokens) {

    Deque<Integer> stack = new LinkedList<Integer>();

    for (String t : tokens) {
      if ("+".equals(t)) {
        stack.push(stack.pop() + stack.pop());
      }
      else if ("-".equals(t)) {
        stack.push(- (stack.pop()) + stack.pop());
      }
      else if ("*".equals(t)) {
        stack.push(stack.pop() * stack.pop());
      }
      else if ("/".equals(t)) {
        int divisor = stack.pop();
        stack.push(stack.pop() / divisor);
      }
      else {
        stack.push(Integer.parseInt(t));
      }
    }

    return stack.pop();
  }
}
