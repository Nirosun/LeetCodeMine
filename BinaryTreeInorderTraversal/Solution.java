/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    TreeNode ptr = root;

    while (!stack.isEmpty() || ptr != null) {
      if (ptr != null) {
        stack.push(ptr);
        ptr = ptr.left;
      }
      else {
        TreeNode tmp = stack.pop();
        result.add(tmp.val);
        ptr = tmp.right;
      }
    }

    return result;
  }
}
