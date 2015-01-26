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
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    traverse (root, 1, result);
    
    reverse(result);
    return result;
  }

  private void traverse(TreeNode root, int level, List<List<Integer>> result) {
    if (root == null) return;

    if (result.size() < level)
    result.add(new ArrayList<Integer>());

    result.get(level - 1).add(root.val);

    traverse(root.left, level + 1, result);
    traverse(root.right, level + 1, result);
  }

  private void reverse(List<List<Integer>> list) {
    List<Integer> tmp = new ArrayList<Integer>();

    for (int i = 0; i < list.size() / 2; i ++) {
      int j = list.size() - 1 - i;
      tmp = list.get(i);
      list.set(i, list.get(j));
      list.set(j, tmp);
    }
  }
}
