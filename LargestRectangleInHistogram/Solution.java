public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height.length == 0) return 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int result = 0;
        List<Integer> l = new ArrayList<Integer>();
        for (int h : height) {
            l.add(h);
        }
        l.add(0);   // ensure that all the elements in stack could be poped

        // non-descending stack
        for (int i = 0; i < l.size();) {
            if (stack.isEmpty() || l.get(i) > l.get(stack.peek())) {
                stack.push(i ++);
            }
            else {  // until find the histogram lower than i-th
                int tmp = stack.pop();
                int width = stack.isEmpty() ? i : (i - 1 - stack.peek());
                result = (result > width * l.get(tmp)) ? result : width * l.get(tmp);
            }
        }

        return result;
    }
}
