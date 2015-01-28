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
  private int[] inorder;
  private int[] postorder;
  int p;

  private TreeNode buildTree(int start, int end) {
    if (start >= end) return null;

    TreeNode root = new TreeNode(postorder[p]);

    int i;
    for (i = start; i < end && postorder[p] != inorder[i]; i ++);

    p --;
    root.right = buildTree(i + 1, end);
    root.left = buildTree(start, i);

    return root;
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    this.inorder = inorder;
    this.postorder = postorder;
    this.p = postorder.length - 1;

    return buildTree(0, inorder.length);
  }
}
