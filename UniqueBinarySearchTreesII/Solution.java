/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) return generate(1, 0);
    return generate(0, n);
  }

  private List<TreeNode> generate(int start, int end) {
    List<TreeNode> subTree = new ArrayList<TreeNode>();
    if (start > end) {
      subTree.add(null);
      return subTree;
    }

    for (int k = start; k < end; k ++) {
      List<TreeNode> leftSubs = generate(start, k);
      List<TreeNode> rightSubs = generate(k + 1, end);

      for (TreeNode i : leftSubs) {
        for (TreeNode j : rightSubs) {
          TreeNode n = new TreeNode(k);
          n.left = i;
          n.right = j;
          subTree.add(n);
        }
      }
    }

    return subTree;
  }
}
