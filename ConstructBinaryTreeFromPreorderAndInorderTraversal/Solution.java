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
  private int[] preorder;
  private int[] inorder;
  int p; // pointer in preorder[]

  private TreeNode buildTree(int start, int end) {
    if (start >= end) return null;

    TreeNode root = new TreeNode(preorder[p]);

    int i;
    for (i = start; i < end && preorder[p] != inorder[i]; i ++);

    p ++; // find the next node by preorder
    root.left = buildTree(start, i);
    root.right = buildTree(i + 1, end);

    return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    this.preorder = preorder;
    this.inorder = inorder;
    this.p = 0;

    return buildTree(0, inorder.length);
  }
}
