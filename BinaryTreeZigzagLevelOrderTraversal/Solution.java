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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    traverse (root, 1, result, true);
    return result;
  }

  private void traverse(TreeNode root, int level, List<List<Integer>> result, boolean isLtoR) {
    if (root == null) return;

    if (result.size() < level)
      result.add(new ArrayList<Integer>());

    if (isLtoR)
      result.get(level - 1).add(root.val);
    else
      result.get(level - 1).add(0, root.val);

    traverse(root.left, level + 1, result, !isLtoR);
    traverse(root.right, level + 1, result, !isLtoR);
  }
}
