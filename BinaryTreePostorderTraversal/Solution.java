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
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();

    if (root == null) return result;

    Deque<TreeNode> stack = new LinkedList<TreeNode>();

    TreeNode cur = root;
    TreeNode prev = null;

    do {
      // go to the leftmost node
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }

      prev = null;

      do {
        cur = stack.pop();
        if (cur.right == prev) {  // right node visited or null, visit cur
          result.add(cur.val);
          prev = cur;
        }
        else {  // right node not visited, push cur & visit right tree
          stack.push(cur);
          cur = cur.right;
          break;  // need to go to the leftmost of right tree
        }
      } while (!stack.isEmpty());

    } while (!stack.isEmpty());

    return result;
  }
}
