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
  TreeNode prev;

  private void preorder(TreeNode root) {
    if (root == null) return;

    TreeNode l = root.left;
    TreeNode r = root.right;

    if (prev != null) {
      prev.right = root;
      prev.left = null;
    }

    prev = root;

    preorder(l);
    preorder(r);
  }

  public void flatten(TreeNode root) {
    prev = null;

    preorder(root);
  }
}
